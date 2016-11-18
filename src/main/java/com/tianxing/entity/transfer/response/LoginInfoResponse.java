package com.tianxing.entity.transfer.response;

/**
 * Created by tianxing on 16/10/29.
 * 登陆信息 用户登录后返回的登录结果
 */
public class LoginInfoResponse {


    private String token;
    private String userType;
    private String date;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
