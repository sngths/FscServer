package com.tianxing.components;

import com.tianxing.module.auth.Account;


/**
 * Created by tianxing on 2017/3/28.
 * 用户账号和权限相关
 */
public interface AccountManager extends Component {



    String ServiceName = "accountService";



    /**
     * 创建用户会话信息
     * */
    Account createAccount();


    /**
     * 取得账户信息
     * */
    Account getAccount(String token);







    /**
     * 注册
     * */



    /**
     * 验证token
     * */
    void authorization(String token)throws Exception;



    /**
     * 取得新的token
     * */




    /**
     * 取得用户信息
     * */






}
