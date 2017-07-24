package com.tianxing.codes.decode;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tianxing.codes.Decoder;
import com.tianxing.codes.exception.DecodeException;

import java.io.IOException;

/**
 * Created by tianxing on 2017/4/15.
 *
 */
public class JsonDecoder implements Decoder {

    private final ObjectMapper mapper;

    private static JsonDecoder decoder;

    private JsonDecoder(){
        mapper = new ObjectMapper();
    }
    public static JsonDecoder getInstance(){
        if (decoder != null){
            return decoder;
        }
        synchronized (JsonDecoder.class){
            if (decoder == null){
                decoder = new JsonDecoder();
            }
        }
        return decoder;
    }


    @Override
    public <T> T decode(String s, Class<T> type) throws DecodeException {
        try {
            return mapper.readValue(s, type);
        } catch (IOException e) {
            throw  new DecodeException();
        }
    }

    @Override
    public <T> T decode(byte[] bytes, Class<T> type) throws DecodeException {
        try {
            return mapper.readValue(bytes, type);
        } catch (IOException e) {
            throw new DecodeException();
        }
    }
}
