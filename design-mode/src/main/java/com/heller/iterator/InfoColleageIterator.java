package com.heller.iterator;

import java.util.Iterator;

public class InfoColleageIterator implements Iterator {
    Department[] departments;
    int n = 0;

    public InfoColleageIterator(Department[] departments) {
        this.departments = departments;
    }

    @Override
    public boolean hasNext() {
        if (n >= departments.length || departments[n] == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Object next() {
        Department department = departments[n];
        n += 1;
        return department;
    }
}
