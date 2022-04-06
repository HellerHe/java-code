package com.heller.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * 减法
 * 线程中递减后，调用await()，不为0时阻塞主线程
 */
public class CountDownLaunch {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(9);
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+" running");
                countDownLatch.countDown();
            }, "thread"+i).start();
        }
        countDownLatch.await();
        System.out.println("主线程执行");
    }
}
