package com.heller;

import java.util.HashMap;
import java.util.Map;

/**
 * 读写锁
 * 写读可以降级为读锁，读写不可以降级为写锁
 */
public class ReadWriteLock {
    private volatile Map<String, Object> map = new HashMap<>();
    private java.util.concurrent.locks.ReadWriteLock readWriteLock = new java.util.concurrent.locks.ReentrantReadWriteLock();

    private Object read(String key) {
        readWriteLock.readLock().lock();
        Object result = null;
        try {
            System.out.println("读取数据");
            Thread.sleep(300);
            result = map.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
        return result;
    }

    private void write(String key, Object value) {
        readWriteLock.writeLock().lock();
        try {
            System.out.println("写入数据");
            Thread.sleep(300);
            map.put(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public static void main(String[] args) {
        ReadWriteLock readWriteLock = new ReadWriteLock();
        readWriteLock.write("a", 1);
        Object a = readWriteLock.read("a");
        System.out.println(a);
    }
}
