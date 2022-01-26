package com.heller.helper;

import java.util.concurrent.BrokenBarrierException;

/**
 * 达到设定值后，await唤醒
 */
public class CyclicBarrier {
    public static void main(String[] args) {
        java.util.concurrent.CyclicBarrier cyclicBarrier = new java.util.concurrent.CyclicBarrier(7, ()->{
            System.out.println("收集齐");
        });
        for (int i = 0; i < 7; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "收集");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, i + "").start();
        }
    }
}
