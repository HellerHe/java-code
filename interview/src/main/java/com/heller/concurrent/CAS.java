package com.heller.concurrent;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * compare and swap
 * 比较工作内存与主存中值，如果相同执行，否则循环比较直到工作内存与主存中值一致为止
 * 1.循环时间开销大
 * 2.只能保证一个共享变量的原子操作
 * 3.ABA问题
 */
public class CAS {
    public static void main(String[] args) {
        System.out.println("------------ABA问题-----------");
        AtomicReference<Integer> num = new AtomicReference<>(1);
        new Thread(new Runnable() {
            @Override
            public void run() {
                num.compareAndSet(1, 2);
                num.compareAndSet(2, 1);
            }
        }, "thread-1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                boolean flag = num.compareAndSet(1, 2);
                System.out.println(flag + " " + num.get());
            }
        }, "thread-2").start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("------------ABA问题解决-----------");
        AtomicStampedReference<Integer> t = new AtomicStampedReference<>(1, 1);
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" stamp:"+t.getStamp());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                t.compareAndSet(1, 2, t.getStamp(), t.getStamp() + 1);
                System.out.println(Thread.currentThread().getName()+" 第一次修改后stamp:"+t.getStamp());
                t.compareAndSet(2, 1, t.getStamp(), t.getStamp() + 1);
                System.out.println(Thread.currentThread().getName()+" 第二次修改后stamp:"+t.getStamp());
            }
        }, "thread-3").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                int stamp = t.getStamp();
                System.out.println(Thread.currentThread().getName()+" stamp:"+stamp);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                boolean b = t.compareAndSet(1, 2, stamp, stamp + 1);
                System.out.println(b + " " + t.getReference() + " " + t.getStamp());
            }
        }, "thread-4").start();
    }
}
