package com.tianxing;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by tianxing on 16/12/28.
 *
 */
public class DynamicProxyTest {



    @Test
    public void test(){
        MyProxy proxy = new MyProxy();
        Subject subject = proxy.getNewInstance(Subject.class);
        System.out.println(subject.doSomething("a"));

    }




    private interface Subject{
        String doSomething(String str);
    }


    private class SubjectImp implements Subject{

        @Override
        public String doSomething(String str) {
            return str;
        }
    }


    private class InvocationHandlerImp implements InvocationHandler{
        private Object target;

        public InvocationHandlerImp(){

        }

        public InvocationHandlerImp(Object o){
            this.target = o;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (this.target != null){
                return method.invoke(this.target, args);
            }else {
                return args[0];
            }

        }
    }


    private class MyProxy{

        @SuppressWarnings("unchecked")
        public <T> T getNewInstance(Class<T> type){
            type.getInterfaces();//类和接口对象 返回结果不同
            return (T) Proxy.newProxyInstance(type.getClassLoader(), new Class[]{type}, new InvocationHandlerImp());
        }



    }
}
