package com.tianxing.codes;

import com.tianxing.codes.decode.JsonDecoder;
import com.tianxing.codes.encode.JsonEncoder;
import com.tianxing.codes.exception.DecodeException;
import com.tianxing.codes.exception.EncodeException;

/**
 * Created by tianxing on 2017/4/14.
 * 统一处理数据编解码
 */
public class CodesManager {



    /**
     * 编码成json字符串
     * */
    public static String encodeAsJsonString(Object o) throws EncodeException {
        return JsonEncoder.getInstance().encodeAsString(o);
    }
    public static String encodeAsJsonString(Object o, Encoder<Object> encoder) throws EncodeException {
        return encoder.encodeAsString(o);
    }

    /**
     * 解码json数据
     * */
    public static <T> T decodeJson(byte[] bytes, Class<T> type) throws DecodeException {
        return JsonDecoder.getInstance().decode(bytes, type);
    }

    public static <T> T decodeJson(String s, Class<T> type) throws DecodeException {
        return JsonDecoder.getInstance().decode(s, type);
    }

}
