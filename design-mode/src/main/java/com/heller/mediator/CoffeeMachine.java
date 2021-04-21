package com.heller.mediator;

public class CoffeeMachine extends Colleague{
    public CoffeeMachine(Mediator mediator, String name) {
        super(mediator, name);
        mediator.register(name, this);
    }

    @Override
    public void sendMessage(int state) {
        this.getMediator().getMessage(state, this.name);
    }

    public void startCoffee() {
        System.out.println("start coffee");
    }

    public void finishCoffee() {
        System.out.println("coffee is ok");
        sendMessage(0);
    }
}
