package com.heller.datastructures.hashtable;

import org.junit.jupiter.api.Test;

public class HashTableTest {
    @Test
    public void test() {
        HashTable hashTable = new HashTable(5);
        hashTable.add(new Employ(1, "1"));
        hashTable.add(new Employ(2, "2"));
        hashTable.add(new Employ(3, "3"));
        Employ employ = hashTable.findById(2);
        System.out.println(employ.toString());
        hashTable.list();
    }
}
