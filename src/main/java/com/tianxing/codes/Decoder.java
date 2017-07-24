package com.tianxing.codes;

import com.tianxing.codes.exception.DecodeException;

/**
 * Created by tianxing on 2017/3/29.
 *
 */
public interface Decoder {

    /**
     * 解码json
     */
    <T> T decode(String s, Class<T> type) throws DecodeException;

    <T> T decode(byte[] bytes, Class<T> type)throws DecodeException;
}
