package com.tianxing.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.tianxing.pojo.TestProtobuf.mMessage;
import org.junit.Test;

/**
 * Created by tianxing on 17/3/6.
 *
 */
public class ProtobufTest {

    //@Test
    public void test() throws InvalidProtocolBufferException {

        mMessage message1 = mMessage.newBuilder().setString1("string1").build();
        mMessage message2 = mMessage.parseFrom(message1.toByteArray());
        System.out.println(message2.getString1());
        int[] ss = new int[1024];
        ByteString bytes;


    }

}
