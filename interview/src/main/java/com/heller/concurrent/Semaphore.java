package com.heller.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * 固定资源数量，多个线程共享资源
 */
public class Semaphore {
    public static void main(String[] args) {
        java.util.concurrent.Semaphore semaphore = new java.util.concurrent.Semaphore(3);//固定资源数
        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();//获取资源
                    System.out.println(Thread.currentThread().getName()+" 获取资源");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName()+" 停留3秒后释放资源");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                  semaphore.release();//释放资源
                }
            }, "thread"+i).start();
        }
    }
}
