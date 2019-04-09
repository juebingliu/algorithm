package com.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author juebing
 * @date 2018/11/16 15:14
 * @description
 */
public class TimeServer {
    public static void main(String[] args) {
        int port = 8080;
        if(args != null && args.length >0) {
            try {
                port = Integer.valueOf(args[0]);
            }catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("The time server is start in port : " + port);
            Socket socket = null;
            TimeServerHandlerExecutePool singleExecutor = new TimeServerHandlerExecutePool(50,10000);
            while (true) {
                socket = server.accept();
                //传统bio
                //new Thread(new TimeServerHandler(socket)).start();
                //改进版的bio（伪异步IO）
                singleExecutor.execute(new TimeServerHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if( server != null) {
                System.out.println("The time server close");
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                server = null;
            }
        }
    }
}