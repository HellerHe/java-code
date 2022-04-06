package com.heller;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 按顺序精准唤醒线程，保证执行顺序
 */
public class CustomCommunicate {
    static class Share {
        private int flag;
        ReentrantLock lock = new ReentrantLock();
        Condition condition0 = lock.newCondition();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();

        public void action1(int rounds) {
            lock.lock();
            try {
                while (flag != 0) {
                    condition0.await();
                }
                System.out.println("第" + rounds + "轮:" + flag);
                flag = 1;
                condition1.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void action2(int rounds) {
            lock.lock();
            try {
                while (flag != 1) {
                    condition1.await();
                }
                for (int i = 0; i < 2; i++) {
                    System.out.println("第" + rounds + "轮:" + flag);
                }
                flag = 2;
                condition2.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void action3(int rounds) {
            lock.lock();
            try {
                while (flag != 2) {
                    condition2.await();
                }
                for (int i = 0; i < 3; i++) {
                    System.out.println("第" + rounds + "轮:" + flag);
                }
                flag = 0;
                condition0.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Share share = new Share();
        int rounds = 3;
        new Thread(()->{
            for (int i = 0; i < rounds; i++) {
                share.action1(i);
            }
        }).start();

        new Thread(()->{
            for (int i = 0; i < rounds; i++) {
                share.action2(i);
            }
        }).start();

        new Thread(()->{
            for (int i = 0; i < rounds; i++) {
                share.action3(i);
            }
        }).start();
    }
}
