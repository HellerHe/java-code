package com.heller.concurrent;

import java.util.concurrent.BrokenBarrierException;

/**
 * 加法
 * 达到设置的值，触发任务
 */
public class CyclicBarrier {
    public static void main(String[] args) {
        java.util.concurrent.CyclicBarrier cyclicBarrier = new java.util.concurrent.CyclicBarrier(2, () -> {
            System.out.println("集齐");
        });
        for (int i = 1; i <= 7; i++) {
            final int finalI = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+" 收集："+ finalI);
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },"thread"+i).start();
        }
    }
}
