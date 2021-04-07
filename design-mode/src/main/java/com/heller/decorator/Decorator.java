package com.heller.decorator;

/**
 * ----装饰者模式
 * 动态的将新功能附加到对象上
 */
public class Decorator extends Drink{
    private Drink drink;

    public Decorator(Drink drink) {
        this.drink = drink;
    }

    @Override
    public Integer cost() {
        return drink.cost() + super.getPrice();
    }

    @Override
    public String getDes() {
        return super.getDes() + " " + super.getPrice() + "&&" + drink.getDes();
    }
}
