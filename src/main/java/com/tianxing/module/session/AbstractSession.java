package com.tianxing.module.session;

import com.tianxing.components.SessionManager;

/**
 * Created by tianxing on 2017/5/18.
 */
public abstract class AbstractSession implements Session{

    private long startTimestamp = 0;

    private String host = "";



    private boolean expired = false;

    private long timeout = 0;

    private SessionManager manager;


    AbstractSession(SessionManager manager){
        startTimestamp = System.currentTimeMillis();
        this.manager = manager;
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public long getStartTimestamp() {
        return startTimestamp;
    }

    @Override
    public long getLastAccessTime() {
        return 0;
    }

    @Override
    public long getTimeout() {
        return 0;
    }

    @Override
    public void setTimeout(long maxIdleTimeInMillis) {

    }


}
