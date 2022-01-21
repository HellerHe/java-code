package com.heller;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CommunicateOfLock {
    static class Share {
        private int num;
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        public void incre() {
            lock.lock();
            try {
                while (num != 0) {
                    condition.await();
                }
                num++;
                System.out.println(Thread.currentThread().getName() + ":" + num);
                condition.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void decre() {
            lock.lock();
            try {
                while (num == 0) {
                    condition.await();
                }
                num--;
                System.out.println(Thread.currentThread().getName() + ":" + num);
                condition.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Share share = new Share();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                share.incre();
            }
        }, "1").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                share.decre();
            }
        }, "2").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                share.decre();
            }
        }, "3").start();
    }
}
