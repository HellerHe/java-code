package com.heller.factory;

/**
 * ----简单工厂
 */
public class SimpleFactory implements AbsFactory {
    @Override
    public Pizza create(String orderTpye) {
        Pizza pizza = null;
        if ("greek".equals(orderTpye)) {
            pizza = new GeekPizza();
            pizza.setName("希腊pizza");
        } else if ("cheese".equals(orderTpye)) {
            pizza = new CheesePizza();
            pizza.setName("奶酪pizza");
        } else if ("pepper".equals(orderTpye)) {
            pizza = new PepperPizza();
            pizza.setName("胡椒pizza");
        } else {
            throw new RuntimeException("无此类型pizza");
        }
        return pizza;
    }
}
