package com.heller.mediator;

import org.junit.jupiter.api.Test;

public class ConcreteMediatorTest {
    @Test
    public void test() {
        ConcreteMediator mediator = new ConcreteMediator();

        Alarm alarm = new Alarm(mediator, "alarm");
        CoffeeMachine coffeeMachine = new CoffeeMachine(mediator, "coffeeMachine");
        Curtains curtains = new Curtains(mediator, "curtains");
        TV tv = new TV(mediator, "TV ");

        alarm.sendAlarm(0);
        coffeeMachine.finishCoffee();
        alarm.sendAlarm(1);
    }
}