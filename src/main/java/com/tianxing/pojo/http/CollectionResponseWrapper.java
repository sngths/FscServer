package com.tianxing.pojo.http;

import com.tianxing.pojo.http.response.Response;

import java.util.List;

/**
 * Created by tianxing on 2017/4/12.
 * 返回数据集类型
 */
public class CollectionResponseWrapper<T extends Response> {

    private int resultCode;
    private String resultMessage;

    List<T> dataList;
}
