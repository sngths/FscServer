package com.tianxing.module.session;

/**
 * Created by tianxing on 2017/5/12.
 *
 */
public interface Session {





    /**
     * token组成:base64(username+":"+expirationTime+":"+md5Hex(username+":"+expirationTime+":"+password+":"+key))
     * key为UUID
     * */
    String getId();

    long getStartTimestamp();

    long getLastAccessTime();

    long getTimeout();


    /**
     * session有效期 默认为30分钟 30*60*1000 = 1800,000毫秒
     * */
    void setTimeout(long maxIdleTimeInMillis);

    /**
     * 更新session 最新操作日期 防止session过期
     * */
    void touch();

    /**
     * 释放session
     * */
    void stop();

    Object getAttribute(Object key);

    void setAttribute(Object key, Object value);

    void removeAttribute(Object key);
}
