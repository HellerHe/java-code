package com.heller.factory;

public class OrderPizza {
    private String orderType;
    private SimpleFactory simpleFactory;
    private Pizza pizza;

    public OrderPizza(String orderType, SimpleFactory simpleFactory) {
        this.orderType = orderType;
        setSimpleFactory(simpleFactory);
    }

    public SimpleFactory getSimpleFactory() {
        return simpleFactory;
    }

    public void setSimpleFactory(SimpleFactory simpleFactory) {
        this.simpleFactory = simpleFactory;
        do {
            pizza = this.simpleFactory.create(orderType);
            if (pizza != null) {
                System.out.println(pizza.getName());
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
                break;
            } else {
                System.out.println("订单失败");
                break;
            }
        } while (true);
    }
}
