package com.heller.factory;

import org.junit.jupiter.api.Test;

public class OrderPizzaTest{
    @Test
    public void orderTest() {
        OrderPizza orderPizza = new OrderPizza("cheese", new SimpleFactory());

    }

}