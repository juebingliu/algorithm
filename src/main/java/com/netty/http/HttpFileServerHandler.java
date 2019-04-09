package com.netty.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.handler.codec.http.*;
import io.netty.handler.stream.ChunkedFile;
import io.netty.util.CharsetUtil;

import javax.activation.MimetypesFileTypeMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.regex.Pattern;

import static io.netty.handler.codec.http.HttpHeaders.isKeepAlive;
import static io.netty.handler.codec.http.HttpHeaders.setContentLength;

/**
 * @author juebing
 * @date 2018/11/21 10:46
 * @description
 */
public class HttpFileServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

    private final String url;

    private static final Pattern INSECURE_URI = Pattern.compile(".*[<>&\"].*");

    private static final Pattern ALLOWD_FILE_NAME = Pattern.compile("[A-Za-z0-9][-_A-Za-z0-9\\.]*");

    public HttpFileServerHandler(String url) {
        this.url = url;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest request) throws Exception {
        if (!request.getDecoderResult().isSuccess()) {
            sendError(ctx,HttpResponseStatus.BAD_REQUEST);
            return;
        }
        if (request.getMethod() != HttpMethod.GET) {
            sendError(ctx,HttpResponseStatus.METHOD_NOT_ALLOWED);
            return;
        }
        final String uri = request.getUri();
        final String path = sanitizeUri(uri);
        if (path == null) {
            sendError(ctx,HttpResponseStatus.FORBIDDEN);
            return;
        }
        File file = new File(path);
        if (file.isHidden() || !file.exists()) {
            sendError(ctx,HttpResponseStatus.NOT_FOUND);
            return;
        }
        if (file.isDirectory()) {
            if (uri.endsWith("/")) {
                sendListing(ctx, file);
            } else {
                sendRedirect(ctx, uri+"/");
                return;
            }
        }
        if (!file.isFile()) {
            sendError(ctx, HttpResponseStatus.FORBIDDEN);
            return;
        }
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
        }catch (FileNotFoundException e) {
            sendError(ctx,HttpResponseStatus.NOT_FOUND);
            return;
        }
        long fileLength = randomAccessFile.length();
        HttpResponse response = new DefaultHttpResponse(HttpVersion.HTTP_1_1,HttpResponseStatus.OK);
        setContentLength(response,fileLength);
        setContentTypeHeader(response,file);
        if(isKeepAlive(request)) {
            request.headers().set(HttpHeaders.Names.CONNECTION,HttpHeaders.Values.KEEP_ALIVE);
        }
        ctx.write(response);
        ChannelFuture sendFileFuture;
        //chunkFile对象直接将文件写入缓冲区
        sendFileFuture = ctx.write(new ChunkedFile(randomAccessFile,0,fileLength,8192),ctx.newProgressivePromise());
        sendFileFuture.addListener(new ChannelProgressiveFutureListener() {
            @Override
            public void operationProgressed(ChannelProgressiveFuture channelProgressiveFuture, long progress, long total) throws Exception {
                if (total < 0) {
                    System.err.println("Transfer progress: " + progress);
                } else {
                    System.err.println("Transfer progress: " + progress + "/" + total);
                }
            }

            @Override
            public void operationComplete(ChannelProgressiveFuture future) throws Exception {
                System.out.println("Transfer complete.");
            }
        });
        ChannelFuture lastContentFuture = ctx.writeAndFlush(LastHttpContent.EMPTY_LAST_CONTENT);
        if( !isKeepAlive(request)) {
            lastContentFuture.addListener(ChannelFutureListener.CLOSE);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        if (ctx.channel().isActive()) {
            sendError(ctx,HttpResponseStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private String sanitizeUri(String uri) {
        try {
            //先对uri进行解码
            uri = URLDecoder.decode(uri, "UTF-8");
        }catch (UnsupportedEncodingException e) {
            try {
                uri = URLDecoder.decode(uri ,"ISO-8859-1");
            } catch (UnsupportedEncodingException e1) {
                throw new Error();
            }
        }
        if (!uri.startsWith(url)) {
            return null;
        }
        if (!uri.startsWith("/")) {
            return null;
        }
        //替换 / 文件分隔符为本地文件分隔符
        uri = uri.replace('/', File.separatorChar);
        if (uri.contains(File.separator+".")
                || uri.contains('.'+File.separator) || uri.startsWith(".")
                || uri.endsWith(".") || INSECURE_URI.matcher(uri).matches()) {
            return null;
        }
        return System.getProperty("user.dir") + File.separator +uri;
    }

    private static void sendListing(ChannelHandlerContext ctx,File dir) {
        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,HttpResponseStatus.OK);
        response.headers().set(HttpHeaders.Names.LOCATION,"text/html;charset=UTF-8");
        StringBuilder buf = new StringBuilder();
        String dirPath = dir.getPath();
        buf.append("<!DOCTYPE html>\r\n");
        buf.append("<html><head><title>");
        buf.append(dirPath);
        buf.append("direcotry:");
        buf.append("</title></head><body>\r\n");
        buf.append("<h3>");
        buf.append(dirPath).append("");
        buf.append("</h3>\r\n");
        buf.append("<ul>");
        buf.append("<li>link:<a href=\"../\">..</a></li>\r\n");
        for (File f : dir.listFiles()) {
            if (f.isHidden() || !f.canRead()) {
                continue;
            }
            String name = f.getName();
            if (!ALLOWD_FILE_NAME.matcher(name).matches()) {
                continue;
            }
            buf.append("<li>link:<a href=\"");
            buf.append(name);
            buf.append("\">");
            buf.append(name);
            buf.append("</a></li>\r\n");
        }
        buf.append("</ul></body></html>\r\n");
        ByteBuf buffer = Unpooled.copiedBuffer(buf, CharsetUtil.UTF_8);
        response.content().writeBytes(buffer);
        buffer.release();
        ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
    }

    private static void sendRedirect(ChannelHandlerContext ctx,String newUri) {
        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.FOUND);
        response.headers().set(HttpHeaders.Names.LOCATION,newUri);
        ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
    }

    private static void sendError(ChannelHandlerContext ctx, HttpResponseStatus status) {
        FullHttpResponse resp = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,status, Unpooled.copiedBuffer("Failure :" + status.toString() + "\r\n", CharsetUtil.UTF_8));
        resp.headers().set(HttpHeaders.Names.CONTENT_TYPE, "text/plain; charset=UTF-8");
        ctx.writeAndFlush(resp).addListener(ChannelFutureListener.CLOSE);
    }

    private static void setContentTypeHeader(HttpResponse resp, File file) {
        MimetypesFileTypeMap mimetypesFileTypeMap = new MimetypesFileTypeMap();
        resp.headers().set(HttpHeaders.Names.CONTENT_TYPE,mimetypesFileTypeMap.getContentType(file.getParent()));
    }
}