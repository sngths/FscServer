package com.tianxing.module.session;

/**
 * Created by tianxing on 2017/5/23.
 *
 */
public interface SessionFactory {


    Session createSession(SessionContext context);
}
