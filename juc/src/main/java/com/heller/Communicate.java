package com.heller;

/**
 * 线程通信
 * synchronized对于普通同步方法,锁的是当前实例对象,通常指this；对于静态同步方法,锁的是当前类的Class对象；对于同步方法块,锁的是 synchronized 括号内的对象
 * Synchronized锁升级：偏向锁-轻量锁-重量锁
 *
 * synchronized 和 lock的区别？
 * 1.原始构成：synchronized是关键字属于JVM层面，字节码monitorenter和monitorexit指令；lock是api层面的锁
 * 2.使用方法：synchronized不需要手动释放；lock需要手动释放，可能会导致死锁的现象
 * 3.等待是否可中断：synchronized不可中断；ReentrantLock可中断(设置超时时间tryLock(long timeout,TimeUnit unit),调用interrupt方法中断)
 * 4.加锁是否公平：synchronized非公平锁；ReentrantLock两者都可以
 * 5.锁绑定多个Condition：ReentrantLock用来实现分组唤醒需要唤醒线程们,可以精确唤醒,而不是像synchronized要么随机唤醒一个\要么多个
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
