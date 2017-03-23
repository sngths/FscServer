package com.tianxing.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;
import com.tianxing.entity.TestProtobuf;
import org.junit.Test;

/**
 * Created by tianxing on 17/3/6.
 */
public class ProtobufTest {

    @Test
    public void test() throws InvalidProtocolBufferException {

        TestProtobuf.mMessage message1 = TestProtobuf.mMessage.newBuilder().setString1("string1").build();
        TestProtobuf.mMessage message2 = TestProtobuf.mMessage.parseFrom(message1.toByteArray());
        System.out.println(message2.getString1());
        int[] ss = new int[1024];
    }

}
