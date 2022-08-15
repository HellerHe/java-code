package com.heller;

import javax.lang.model.element.VariableElement;

/**
 * 守护进程
 */
public class ThreadOfDaemon {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                    System.out.println("子线程running...");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        //thread.setDaemon(true);
        thread.start();
        Thread.sleep(3000);
        System.out.println("主线程结束");
    }
}
