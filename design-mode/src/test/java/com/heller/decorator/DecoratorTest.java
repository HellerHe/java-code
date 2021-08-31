package com.heller.decorator;

import org.junit.jupiter.api.Test;


public class DecoratorTest {
    @Test
    public void test() {
        Drink order = new DeCaf();
        System.out.println(order.getPrice());
        System.out.println(order.getDes());

        order = new Milk(order);
        System.out.println("加入一份" + order.getDes());
        System.out.println("费用 "+ order.getPrice());

        order = new Chocolate(order);
        System.out.println("加入一份" + order.getDes());
        System.out.println("费用 "+ order.getPrice());
    }
}