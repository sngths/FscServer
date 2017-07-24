package com.tianxing.module.session;

import com.tianxing.components.SessionManager;


/**
 * Created by tianxing on 2017/5/12.
 *
 */
public class HttpSession extends AbstractSession {





    public HttpSession(SessionContext context){
        super(SessionManagerImpl.getManager());
    }


    public HttpSession(SessionManager manager, SessionContext context){
        super(manager);
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


    public static class Builder{

        private SessionManager manager;


        private SessionContext context;

        public Builder(){
           this(SessionManagerImpl.getManager());
        }

        public Builder(SessionManager manager){
            this.manager = manager;
            context = new SessionContext();
        }


        public void setHost(String host){

        }





        public HttpSession build(){
            return new HttpSession(context);
        }
    }
}
