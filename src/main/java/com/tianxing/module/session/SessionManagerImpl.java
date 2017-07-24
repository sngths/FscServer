package com.tianxing.module.session;

import com.tianxing.components.AbstractComponent;
import com.tianxing.components.mediator.ComponentMediator;
import com.tianxing.components.SessionManager;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by tianxing on 2017/3/28.
 *
 */
public class SessionManagerImpl extends AbstractComponent implements SessionManager {


    private static SessionManager sessionManager;

    private ComponentMediator mediator;



    /**
     * session 时间戳
     * */
    private ConcurrentHashMap<String, AtomicLong> sessionTimestampMap;





    private SessionManagerImpl(){}


    public static SessionManager getManager(){
        if (sessionManager == null){
            throw  new RuntimeException("SessionManager is uninitialized");
        }
        return sessionManager;
    }


    @Override
    public String getName() {
        return ServiceName;
    }


    @Override
    public void initialize(ComponentMediator mediator) {
        this.mediator = mediator;
        sessionTimestampMap = new ConcurrentHashMap<>();
        sessionManager = mediator.getComponent(SessionManager.class);
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {

    }


    @Override
    public long getLastAccessTime(String id) {
        return 0;
    }
}
