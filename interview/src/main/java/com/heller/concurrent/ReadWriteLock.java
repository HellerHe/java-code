package com.heller.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 * 写阻塞，读并发
 * 当读写锁被加了写锁时，其他线程对该锁加读锁或者写锁都会阻塞（不是失败）。
 * 当读写锁被加了读锁时，其他线程对该锁加写锁会阻塞，加读锁会成功。
 */
public class ReadWriteLock {
    private Map<String, Object> map = new HashMap<>();
    ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    public void write(String key, Object value) {
        readWriteLock.writeLock().lock();
        System.out.println(Thread.currentThread().getName()+"写");
        try {
            TimeUnit.SECONDS.sleep(1);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName()+"写完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public Object read(String key) {
        readWriteLock.readLock().lock();
        System.out.println(Thread.currentThread().getName()+"读");
        Object o = null;
        try {
            TimeUnit.SECONDS.sleep(1);
            o = map.get(key);
            System.out.println(Thread.currentThread().getName()+"读完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
        return o;
    }

    public static void main(String[] args) {
        ReadWriteLock lock = new ReadWriteLock();
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                lock.write("a", 1);
                lock.read("a");
            }, "thread"+i).start();
        }
    }
}
