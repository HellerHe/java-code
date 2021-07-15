package com.heller.datastructures.hashtable;

import java.util.LinkedList;
import java.util.List;

/**
 * ----哈希表（散列）
 * 数组 + 链表
 */
public class HashTable {
    private int size;
    private EmployArr[] employArr;

    public HashTable(int size) {
        this.size = size;
        employArr = new EmployArr[size];
        for (int i = 0; i < size; i++) {
            employArr[i] = new EmployArr();
        }
    }

    private int hash(int id) {
        return id % size;
    }

    public void add(Employ employ) {
        int id = employ.getId();
        employArr[hash(id)].add(employ);
    }

    public void list() {
        for (int i = 0; i < size; i++) {
            employArr[i].list(i);
        }
    }

    public Employ findById(int id) {
        return employArr[hash(id)].find(id);
    }
}
