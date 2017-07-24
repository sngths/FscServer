package com.tianxing.pojo.http;

import com.tianxing.codes.CodesManager;
import com.tianxing.codes.exception.DecodeException;

/**
 * Created by tianxing on 2017/4/15.
 *
 */
public class RequestWrapper {

    private int type;//rawData解码成的对象类型 -1表示结果为空
    private String rawData;//json格式字符串 可进一步解码成对象


    public int getType() {
        return type;
    }

    public String getRawData() {
        return rawData;
    }


    /**
     * 解码成对象
     * */
    public <T> T deserialize(Class<T> classType) throws DecodeException{
        if (classType.getClass().getName().hashCode() != type){
            throw new DecodeException();
        }
        return CodesManager.decodeJson(rawData, classType);
    }



}
