package com.tianxing;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * Created by tianxing on 16/12/29.
 *
 */
public class MD5Test {

    @Test
    public void test(){
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bytes = messageDigest.digest("aasdaa".getBytes(StandardCharsets.UTF_8));



            Random rand = new Random();
            byte[] salt = new byte[12];
            rand.nextBytes(salt);
            System.out.println(new BigInteger(salt).toString(32));
            messageDigest.update(salt);
            messageDigest.update("a".getBytes(StandardCharsets.UTF_8));
            System.out.println(new BigInteger(1, messageDigest.digest()).toString(32));

            DigestUtils.md5("asd" + new BigInteger(salt).toString(32));


        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
