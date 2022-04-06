package com.heller.concurrent;

/**
 * volatile 1.可见性 2.不保证原子性 3.有序性
 * atomic 可以保证原子性
 */
public class VolatileTest {
    private volatile  int num = 0;

    private void add() {
        num = num+10;
    }

    public static void main(String[] args) {
        VolatileTest volatileTest = new VolatileTest();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                volatileTest.add();
                System.out.println("work thread : " + volatileTest.num);
            }
        }, "thread").start();

        while (volatileTest.num == 0) {
            //不加volatile不能保证可见性，会进入循环
        }

        System.out.println("main thread : " + volatileTest.num);
    }
}
