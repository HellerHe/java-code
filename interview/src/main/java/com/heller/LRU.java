package com.heller;

import org.junit.platform.commons.util.LruCache;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 最近最少使用
 */
public class LRU<K,V> extends LinkedHashMap<K, V> {
    private int capacity;

    public LRU(int capacity) {
        super(capacity, 0.75F, false);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return super.size()>capacity;
    }

    public static void main(String[] args) {
        LRU<Integer, Integer> cache = new LRU<>(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        System.out.println(cache.keySet());
        cache.put(3, 3);
        System.out.println(cache.keySet());
        cache.put(3, 3);
        System.out.println(cache.keySet());
        cache.put(5, 5);
        System.out.println(cache.keySet());

    }
}
