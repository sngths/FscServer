package com.tianxing.module.session;

import com.tianxing.components.SessionManager;

/**
 * Created by tianxing on 2017/5/12.
 */
public class TcpSession extends AbstractSession {



    public TcpSession() {
        super(SessionManagerImpl.getManager());
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public long getStartTimestamp() {
        return 0;
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

    @Override
    public void touch() {

    }

    @Override
    public void stop() {

    }

    @Override
    public Object getAttribute(Object key) {
        return null;
    }

    @Override
    public void setAttribute(Object key, Object value) {

    }

    @Override
    public void removeAttribute(Object key) {

    }
}
