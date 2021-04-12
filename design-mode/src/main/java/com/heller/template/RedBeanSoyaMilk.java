package com.heller.template;

public class RedBeanSoyaMilk extends SoyaMilk{
    @Override
    void addCondiments() {
        System.out.println(" 加入上好的红豆 ");
    }

    @Override
    boolean customerWantCondiments() {
        return false;
    }
}
