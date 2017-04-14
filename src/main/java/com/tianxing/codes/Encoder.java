package com.tianxing.codes;

import com.tianxing.codes.exception.EncodeException;

/**
 * Created by tianxing on 2017/3/29.
 */
public interface Encoder<T> {


    /**
     * 编码成字节数组
     * */
    byte[] encodeAsBytes(T t) throws EncodeException;

    /**
     * 编码成字符串
     * */
    String encodeAsString(T t) throws EncodeException;

}
