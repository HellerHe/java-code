package com.heller.helper;

/**
 * 信号灯
 */
public class Semaphore {
    public static void main(String[] args) {
        java.util.concurrent.Semaphore semaphore = new java.util.concurrent.Semaphore(3);//许可证
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + "获得");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName() + "释放");
                }
            }, i+"").start();
        }
    }
}
