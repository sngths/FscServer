package com.tianxing.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;
import com.tianxing.entity.Testentity;
import org.junit.Test;

/**
 * Created by tianxing on 17/3/6.
 */
public class ProtobufTest {

    @Test
    public void test() throws InvalidProtocolBufferException {
        Testentity.aaa aaa  = Testentity.aaa.newBuilder().setAasa("aaa").build();
        Testentity.aaa aaa1 = Testentity.aaa.parseFrom(aaa.toByteArray());
        System.out.println(aaa1.getAasa());
        int[] ss = new int[1024];
    }

}
