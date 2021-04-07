package com.heller.decorator;

public class Coffee extends Drink{
    @Override
    public Integer cost() {
        return super.getPrice();
    }
}
