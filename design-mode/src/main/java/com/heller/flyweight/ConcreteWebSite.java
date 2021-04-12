package com.heller.flyweight;

public class ConcreteWebSite implements WebSite{
    private String type;

    public ConcreteWebSite(String type) {
        this.type = type;
    }

    @Override
    public void user(String name) {
        System.out.println("网站的发布形式为:" + type + " 在使用中 .. 使用者是" + name);
    }
}
