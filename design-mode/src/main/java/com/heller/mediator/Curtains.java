package com.heller.mediator;

public class Curtains extends Colleague{
    public Curtains(Mediator mediator, String name) {
        super(mediator, name);
        mediator.register(name, this);
    }

    @Override
    public void sendMessage(int state) {
        this.getMediator().getMessage(state, name);
    }

    public void up() {
        System.out.println("curtains up");
    }
}
