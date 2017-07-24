package com.tianxing;

import com.tianxing.codes.CharacterCodes;
import org.assertj.core.internal.Strings;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.Server;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * Created by tianxing on 16/10/27.
 */
public class UtilTest {

    Logger logger = LoggerFactory.getLogger(UtilTest.class);

    @Test
    public void dateTest(){
        logger.info(Server.getDate());
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info(Server.getDate());
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info(Server.getDate());
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info(Server.getDate());
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    @Test
    public void test(){



        Date date = new Date();
        try {
            Class a = Class.forName("java.util.Date");
            System.out.print(a.getModifiers());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void pojo(){
        String s = "aaa";

        System.out.println(CharacterCodes.md5Hex(s));

        System.out.println(CharacterCodes.base64Encode(CharacterCodes.md5Hex(s)));
        System.out.println(CharacterCodes.base64Decode(CharacterCodes.base64Encode(CharacterCodes.md5Hex(s))));
        System.out.println(UUID.randomUUID().toString());
    }


    private <T>void print(T t){
        System.out.println(t.getClass().getSimpleName().toLowerCase());
    }
}
