package com.heller.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * University 就是 Composite , 可以管理 College
 */
public class University extends OrganizationComponent{
    List<OrganizationComponent> components = new ArrayList<OrganizationComponent>();

    public University(String name, String des) {
        super(name, des);
    }

    @Override
    public void add(OrganizationComponent component) {
        components.add(component);
    }

    @Override
    public void remove(OrganizationComponent component) {
        components.remove(component);
    }

    @Override
    public void print() {
        System.out.println("--------------" + getName() + "--------------");
        for (OrganizationComponent component : components) {
            component.print();
        }
    }
}
