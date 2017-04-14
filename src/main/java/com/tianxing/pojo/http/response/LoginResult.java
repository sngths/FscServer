package com.tianxing.pojo.http.response;

import com.tianxing.codes.encode.JsonEncoder;
import com.tianxing.codes.exception.EncodeException;

/**
 * Created by tianxing on 2017/4/14.
 * 用户登录完成 返回的登录结果
 */
public class LoginResult implements Response{

    private int userId;
    private String userName;
    private String iconUrl;
    private String userType;

    private String token;
    private String refreshToken;







    @Override
    public String serialize() throws EncodeException {
        return JsonEncoder.getInstance().encodeAsString(this);
    }
}
