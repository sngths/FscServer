package com.tianxing.Lock;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by tianxing on 16/12/8.
 */
public class LockTest {

    ConcurrentHashMap<Long, ReentrantLock> lockMap = new ConcurrentHashMap<>();

    AtomicInteger lockCount = new AtomicInteger();

    @Test
    public void lockTest(){

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    lock();
                }
            }).start();
        }

        try {
            Thread.currentThread().sleep(5000);

            for (ReentrantLock lock:lockMap.values()) {
                synchronized (lock){
                    lock.notify();
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    private void lock(){

        ReentrantLock lock = new ReentrantLock();

        lockMap.put(Thread.currentThread().getId(), lock);

        synchronized (lock){

            try {
                System.out.println("线程" + Thread.currentThread().getName() + "等待中");
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                lockMap.remove(lock);
            }

            lockMap.remove(lock);
            System.out.println("线程" + Thread.currentThread().getName() + "释放");
        }

    }


    @Test
    public void Lock2Test(){
        for (int i = 0; i < 10; i++) {
            new Thread(this::lock2).start();
        }


        try {
            Thread.currentThread().sleep(5000);

            for (;;){
                synchronized (lock){
                    if (lockCount.get() > 0){
                        lock.notifyAll();
                    }else {
                        break;
                    }
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    Object lock = new Object();
    private void lock2(){

        synchronized (lock){
            try {
                lockCount.incrementAndGet();
                System.out.println("线程" + Thread.currentThread().getName() + "等待中");
                lock.wait();
                lockCount.decrementAndGet();
            } catch (InterruptedException e) {
                e.printStackTrace();
                lockCount.decrementAndGet();
            }

            System.out.println("线程" + Thread.currentThread().getName() + "释放");
        }
    }
}
