package com.heller.iterator;

import java.util.Iterator;
import java.util.List;

/**
 * ----迭代器模式
 * 提供一种遍历集合元素的统一接口，用一致的方法遍历集合元素，不需要知道集合对象的底层表示
 */
public class University {
    College[] colleges;

    public University(College[] colleges) {
        this.colleges = colleges;
    }

    public void printCollege() {
        for (int i = 0; i < colleges.length; i++) {
            System.out.println(colleges[i].getName());
            Iterator iterator = colleges[i].createIterator();
            while (iterator.hasNext()) {
                Department department = (Department)iterator.next();
                System.out.println(department.toString());
            }
        }
    }
}
