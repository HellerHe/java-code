package com.heller;

/**
 * 线程通信
 */
public class Communicate {
    public static void main(String[] args) {
        Share share = new Share();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        share.incre();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"1").start();

        new Thread(()->{
            try {
                for (int i = 0; i < 10; i++) {
                    share.decre();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "2").start();

        new Thread(()->{
            try {
                for (int i = 0; i < 10; i++) {
                    share.decre();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "3").start();
    }
    static class Share {
        private int num;
        public synchronized void incre() throws InterruptedException {
            while (num != 0) {  //虚假唤醒，不能使用if判断
                this.wait();
            }
            num++;
            System.out.println(Thread.currentThread().getName() + ":" + num);
            this.notify();
        }

        public synchronized void decre() throws InterruptedException {
            while (num == 0) {
                this.wait();
            }
            num--;
            System.out.println(Thread.currentThread().getName() + ":" + num);
            this.notify();
        }
    }
}
