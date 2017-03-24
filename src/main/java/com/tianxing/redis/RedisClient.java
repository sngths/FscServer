package com.tianxing.redis;

/**
 * Created by tianxing on 2017/3/7.
 * 实现redis的基本设置和控制
 */
public interface RedisClient {



    //取得连接池


    //取得一个连接



    /**
     * 关闭redis客户端
     * */
    public void close();
}
