package com.tianxing.codes.encode;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tianxing.codes.Encoder;
import com.tianxing.codes.exception.EncodeException;

/**
 * Created by tianxing on 2017/4/14.
 *
 */
public class JsonEncoder implements Encoder<Object>{


    private static JsonEncoder encoder = new JsonEncoder();

    private final ObjectMapper mapper;

    private JsonEncoder(){
        mapper = new ObjectMapper();
    }

    public static JsonEncoder getInstance(){
        return encoder;
    }


    @Override
    public byte[] encodeAsBytes(Object o) throws EncodeException {
        try {
            return mapper.writeValueAsBytes(o);
        } catch (JsonProcessingException e) {
            throw new EncodeException();
        }
    }

    @Override
    public String encodeAsString(Object o) throws EncodeException {
        try {
            return mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new EncodeException();
        }
    }
}
