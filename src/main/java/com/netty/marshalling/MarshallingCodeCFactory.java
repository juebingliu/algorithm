package com.netty.marshalling;


import com.netty.protocolstack.util.NettyMarshallingDecoder;
import com.netty.protocolstack.util.NettyMarshallingEncoder;
import io.netty.handler.codec.marshalling.*;
import org.jboss.marshalling.MarshallerFactory;
import org.jboss.marshalling.Marshalling;
import org.jboss.marshalling.MarshallingConfiguration;

/**
 * @author juebing
 * @date 2018/11/21 9:17
 * @description
 */
public class MarshallingCodeCFactory {
    //marshalling解码
    public static NettyMarshallingDecoder buildMarshallingDecoder() {
        final MarshallerFactory marshallerFactory = Marshalling.getMarshallerFactory("serial");
        final MarshallingConfiguration configuration = new MarshallingConfiguration();
        configuration.setVersion(5);
        UnmarshallerProvider provider = new DefaultUnmarshallerProvider(marshallerFactory,configuration);
        NettyMarshallingDecoder decoder = new NettyMarshallingDecoder(provider,1024);
        return decoder;
    }

    //marshalling编码
    public static NettyMarshallingEncoder buildMarshallingEncoder() {
        final MarshallerFactory marshallerFactory = Marshalling.getMarshallerFactory("serial");
        final MarshallingConfiguration configuration = new MarshallingConfiguration();
        configuration.setVersion(5);
        MarshallerProvider provider = new DefaultMarshallerProvider(marshallerFactory,configuration);
        NettyMarshallingEncoder encoder = new NettyMarshallingEncoder(provider);
        return encoder;
    }


}