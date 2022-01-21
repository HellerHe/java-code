package com.heller;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 集合线程安全
 * 1.Vector
 * 2.Collections.synchronizedList
 * 3.CopyOnWriteArrayList/ConcurrentHashMap √ 复制一份数据，新增完数据再合并回去
 */
public class CollectionSafe {
    public static void main(String[] args) {
        //List<Integer> list = new Vector<Integer>();2.
        //List<Integer> list = Collections.synchronizedList(new ArrayList<Integer>());
        List<Integer> list = new CopyOnWriteArrayList<>();

        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(random.nextInt(10));
                System.out.println(list);
            }, i+"").start();
        }
    }
}
