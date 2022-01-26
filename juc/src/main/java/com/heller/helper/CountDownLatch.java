package com.heller.helper;

/**
 * 计数器变为0时，await唤醒
 */
public class CountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName());
                countDownLatch.countDown();
            },i + "").start();
        }
        countDownLatch.await();
        System.out.println("down");
        System.out.println(countDownLatch.getCount());
    }
}
