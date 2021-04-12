package com.heller.composite;

/**
 * ----组合模式
 * 1. 简化客户端操作。客户端只需要面对一致的对象而不用考虑整体部分或者节点叶子的问题。
 * 2. 需要遍历组织机构，或者处理的对象具有树形结构时, 非常适合使用组合模式
 */
public abstract class OrganizationComponent {
    private String name;
    private String des;

    public abstract void add(OrganizationComponent component);

    public abstract void remove(OrganizationComponent component);

    public abstract void print();

    public OrganizationComponent(String name, String des) {
        this.name = name;
        this.des = des;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
