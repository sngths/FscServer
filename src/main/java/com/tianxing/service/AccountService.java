package com.tianxing.service;

/**
 * Created by tianxing on 2017/3/28.
 * 用户账号和权限相关
 */
public interface AccountService extends Service {

    String ServiceName = "AccountService";

    /**
     * 取得用户信息
     * */

    /**
     * 验证账户权限
     * */


    /**
     * 验证token
     * */
    void verifyToken(String token);

}
