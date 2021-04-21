package com.heller.iterator;

import java.util.Iterator;

public class InfoColleage implements College{
    Department[] departments;
    int n = 0;

    public InfoColleage(Department[] departments) {
        this.departments = departments;
    }

    @Override
    public String getName() {
        return "信息工程学院";
    }

    @Override
    public Department[] addDepartment(String name, String des) {
        departments[n] = new Department(name, des);
        n += 1;
        return departments;
    }

    @Override
    public Iterator createIterator() {
        return new InfoColleageIterator(departments);
    }
}
