package com.netty.protobuf.proto;

import com.google.protobuf.InvalidProtocolBufferException;

/**
 * @author juebing
 * @date 2018/11/20 18:44
 * @description
 */
public class ProtoTest {
        public static void main(String[] args) throws InvalidProtocolBufferException {
//            SubscribeReqProto.SubscribeReq.Builder builder = SubscribeReqProto
//                    .SubscribeReq.newBuilder()
//                    .setSubReqID(1)
//                    .setUserName("123")
//                    .setProductName("abc")
//                    .setPhoneNumber("789")
//                    .setAddress("108.st");
//
//       final SubscribeReqProto.SubscribeReq build = builder.build();
//        System.out.println(build);
            SubscribeReqProto.SubscribeReq req = createSubscribeReq();
            System.out.println("before encode : " + req.toString());
            SubscribeReqProto.SubscribeReq req2 = decode(encode(req));
            System.out.println("after decode : " + req.toString());
            System.out.println(req2.equals(req));
    }

    private static byte[] encode(SubscribeReqProto.SubscribeReq req) {
            return req.toByteArray();
    }

    private static SubscribeReqProto.SubscribeReq decode(byte[] body) throws InvalidProtocolBufferException {
            return SubscribeReqProto.SubscribeReq.parseFrom(body);
    }

    private static SubscribeReqProto.SubscribeReq createSubscribeReq() {
            return SubscribeReqProto.SubscribeReq.newBuilder()
                    .setSubReqID(1)
                    .setUserName("abc")
                    .setProductName("吃的")
                    .setAddress("a city").build();

    }
}