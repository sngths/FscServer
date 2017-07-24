package com.tianxing.codes;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;

/**
 * Created by tianxing on 2017/5/15.
 *
 */
public class CharacterCodes {


    public static String md5Hex(String s){
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(s.getBytes(StandardCharsets.UTF_8));
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            throw new RuntimeException("");
        }
    }


    public static String base64Encode(String s){
        return new String(Base64.getEncoder().encode(s.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);
    }

    public static String base64Decode(String s){
        return new String(Base64.getDecoder().decode(s.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);
    }
}
