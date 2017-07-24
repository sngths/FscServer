package com.tianxing.pojo.http;


import com.tianxing.codes.CodesManager;
import com.tianxing.codes.exception.EncodeException;
import com.tianxing.pojo.http.response.Response;

/**
 * Created by tianxing on 2017/4/12.
 *
 */
public class ResponseWrapper  {
    private int statusCode = 200;//http状态码
    private String resultMessage;
    private int type;//rawData解码成的对象类型 -1表示结果为空
    private String rawData;//json格式字符串 可进一步解码成对象

    /**
     * 传入json编码的字符串
     * */
    public ResponseWrapper(String rawData, Class<?> type){
        if (rawData == null){
            this.type = -1;
            return;
        }
        this.type = type.getName().hashCode();
        this.rawData = rawData;
    }

    public <T>ResponseWrapper(T t){
        if (t == null){
            this.type = -1;
            return;
        }
        this.type = t.getClass().getName().hashCode();
        try {
            rawData = CodesManager.encodeAsJsonString(t);
        } catch (EncodeException e) {
            //编码错误 记入日志
            this.type = -1;
        }
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public int getType() {
        return type;
    }

    public String getRawData() {
        return rawData;
    }
}
