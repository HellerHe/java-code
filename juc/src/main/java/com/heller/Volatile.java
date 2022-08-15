package com.heller;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * volatile:保证可见性、有效性，不保证原子性；volatile关键字靠的是StoreStore、StoreLoad 、LoadLoad、LoadStore四条内存屏障指令
 * 多个写操作时：线程1在工作内存修改完num后写入主存时，线程2抢到CPU执行权从主存拿到num已经修改了num，当线程1写入主存后，
 * 通知其它线程2从主存中读取num到工作内存然后计算，造成数据丢失。
 *
 * read-load-use和assign-store-write成为了两个不可分割的原子操作，但是在use和assign之间依然有极小的一段真空期（数据加载、计算、赋值），有可能变量会被其他线程读取，导致写丢失一次
 */
public class Volatile {
    public static void main(String[] args) throws InterruptedException {
        Resource resource = new Resource();
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int j = 0; j < 100; j++) {
                    resource.add();
                    resource.plus();
                }
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }
        countDownLatch.await();
        /*while (Thread.activeCount() > 2) {
            Thread.yield();
        }*/
        System.out.println("num:"+resource.num);
        System.out.println("atomic num:"+resource.atomicNum.get());
    }

    static class Resource{
        private volatile int num=0;
        private AtomicInteger atomicNum = new AtomicInteger(0);

        public int add() {
            return num++;
        }

        public int plus() {
            return atomicNum.getAndIncrement();
        }
    }
}

