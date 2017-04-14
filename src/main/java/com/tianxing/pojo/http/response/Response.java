package com.tianxing.pojo.http.response;

import com.tianxing.codes.exception.EncodeException;

/**
 * Created by tianxing on 2017/4/12.
 * http请求的返回数据类型实现该接口
 */
public interface Response {

    /**
     * 编码成json字符串
     * */
    String serialize() throws EncodeException;
}
