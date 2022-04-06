package com.heller.concurrent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class SafeList {
    public static void main(String[] args) {
        List<Integer> list = new Vector<>();
        List<Integer> list1 = Collections.synchronizedList(new ArrayList<Integer>());
        List<Integer> list2 = new CopyOnWriteArrayList<>();
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
    }
}
