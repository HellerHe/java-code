package com.heller;

import java.util.concurrent.TimeUnit;

/**
 * 通过Thread类自带的中断API interrupt()方法实现中断：
 * 将线程的中断标志设置位true，仅此而已，线程将继续正常运行,不受影响。
 * 停止需要被调用的线程自己进行配合才行。
 * 如果处于被阻塞状态（sleep、wait、join）调用interrupt，线程立即被阻塞状态，并抛出一个InterruptedException异常，
 * 抛出InterruptedException后，中断标识也被清空置为false，需要在catch中调用interrupt()方法再次将中断标识位设置位true，否则无限循环
 */
public class Interrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("-----isInterrupted() = true,程序结束。");
                    break;
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    //线程的中断标志位重新设置为false,无法停下,需要再次掉interrupt()设置true
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
                System.out.println("------hello Interrupt");
            }
        }, "1");
        thread1.start();

        TimeUnit.SECONDS.sleep(3);

        Thread thread2 = new Thread(() -> {
            thread1.interrupt();
        }, "2");
        thread2.start();
    }
}
