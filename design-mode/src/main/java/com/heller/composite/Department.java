package com.heller.composite;

/**
 * 叶子节点
 */
public class Department extends OrganizationComponent{
    public Department(String name, String des) {
        super(name, des);
    }

    @Override
    public void add(OrganizationComponent component) {

    }

    @Override
    public void remove(OrganizationComponent component) {

    }

    @Override
    public void print() {
        System.out.println(getName() + getDes());
    }
}
