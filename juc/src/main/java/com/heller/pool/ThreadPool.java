package com.heller.pool;

import java.util.concurrent.*;

/**
 * 拒绝策略：
 * AbortPolicy 抛异常
 * CallerRunsPolicy 原路返回，使用原线程执行
 * DiscardPolicy 直接拒绝丢弃
 * DiscardOldestPolicy 丢弃最老的任务，加入新任务
 * 线程池原理：
 *
 */
public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        ExecutorService threadPool1 = Executors.newSingleThreadExecutor();
        ExecutorService threadPool2 = Executors.newCachedThreadPool();

        ThreadPoolExecutor threadPool3 = new ThreadPoolExecutor(3, 5, 1L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());

        for (int i = 0; i < 10; i++) {
            threadPool3.execute(()->{
                System.out.println(Thread.currentThread().getName() + ":执行" );
            });
        }
    }
}
