package com.heller.concurrent;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁：采用循环方式尝试获取锁
 * 优点：减少线程上下文切换消耗
 * 缺点：可能长时间循化，消耗cpu
 */
public class SpinLock {
    private AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void lock() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+" get lock");
        while (!atomicReference.compareAndSet(null, thread)) {
            //自旋
        }

    }

    public void unLock() {
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread, null);
        System.out.println(thread.getName()+" release lock");
    }

    public static void main(String[] args) throws InterruptedException {
        SpinLock spinLock = new SpinLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                spinLock.lock();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                spinLock.unLock();
            }
        }, "A").start();
        Thread.sleep(100);
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"尝试获取锁。。。");
                spinLock.lock();
                spinLock.unLock();
            }
        }, "B").start();
    }
}
