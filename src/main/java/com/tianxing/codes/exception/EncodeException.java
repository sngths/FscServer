package com.tianxing.codes.exception;

/**
 * Created by tianxing on 2017/4/14.
 * 编码出错
 */
public class EncodeException extends Exception {

    public EncodeException(){}

    public EncodeException(String s){
        super(s);
    }
}
