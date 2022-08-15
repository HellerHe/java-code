package com.heller;

import java.util.concurrent.TimeUnit;

/**
 * 1.最多只有一个凭证permit
 * 2.跟顺序无关
 */
public class LockSupport {
    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(() -> {

            System.out.println(Thread.currentThread().getName()+"进入，准备park");
            java.util.concurrent.locks.LockSupport.park();//被阻塞
            //java.util.concurrent.locks.LockSupport.park();//多次调用uppark只会发一个凭证
            System.out.println(Thread.currentThread().getName()+"放行");
        }, "a");
        a.start();
        try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
        Thread b = new Thread(() -> {
            java.util.concurrent.locks.LockSupport.unpark(a);
            java.util.concurrent.locks.LockSupport.unpark(a);
            System.out.println(Thread.currentThread().getName()+"通知");
        }, "b");
        b.start();
    }
}
