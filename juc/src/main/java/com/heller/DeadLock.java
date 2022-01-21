package com.heller;

/**
 * 死锁
 * 检查：jsp jstack
 */
public class DeadLock {
    public static void main(String[] args) {
        Object a = new Object();
        Object b = new Object();
        new Thread(()->{
            synchronized (a) {
                System.out.println("已获取a锁，准备获取b锁");
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (b){
                    System.out.println("获取b锁");
                }
            }
        },"a").start();
        new Thread(()->{
            synchronized (b) {
                System.out.println("已获取b锁，准备获取a锁");
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (a){
                    System.out.println("获取a锁");
                }
            }
        },"b").start();
    }
}
