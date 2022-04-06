package com.heller.oom;

import java.util.concurrent.TimeUnit;

public class UnableCreateNewThread {
    public static void main(String[] args) {
        for (int i = 0; ; i++) {
            System.out.println(i);
            new Thread(()->{
                try {
                    TimeUnit.DAYS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
