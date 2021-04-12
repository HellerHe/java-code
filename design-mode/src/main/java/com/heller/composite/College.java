package com.heller.composite;

import java.util.ArrayList;
import java.util.List;

public class College extends OrganizationComponent{
    List<OrganizationComponent> components = new ArrayList<OrganizationComponent>();

    public College(String name, String des) {
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
