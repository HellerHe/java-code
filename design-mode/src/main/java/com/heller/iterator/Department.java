package com.heller.iterator;

public class Department {
    private String name;
    private String des;

    public Department(String name, String des) {
        this.name = name;
        this.des = des;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", des='" + des + '\'' +
                '}';
    }
}
