package com.heller.strategy;

public class WildDuck extends Duck{
    public WildDuck() {
        flyBehavior = new GoodFlyBehavior();
    }
}
