package com.heller.strategy;

public class PekingDuck extends Duck{
    public PekingDuck() {
        flyBehavior = new BadFlyBehavior();
    }
}
