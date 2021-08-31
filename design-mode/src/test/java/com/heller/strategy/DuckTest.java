package com.heller.strategy;

import org.junit.jupiter.api.Test;

public class DuckTest {
    @Test
    public void test() {
        WildDuck wildDuck = new WildDuck();
        wildDuck.fly();
        ToyDuck toyDuck = new ToyDuck();
        toyDuck.fly();
        PekingDuck pekingDuck = new PekingDuck();
        pekingDuck.fly();

        pekingDuck.setFlyBehavior(new NoFlyBehavior());
        pekingDuck.fly();
    }
}