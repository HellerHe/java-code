package com.heller.mediator;

public class Alarm extends Colleague{
    public Alarm(Mediator mediator, String name) {
        super(mediator, name);
        mediator.register(name, this);
    }

    public void sendAlarm(int state) {
        sendMessage(state);
    }

    @Override
    public void sendMessage(int state) {
        this.getMediator().getMessage(state, this.name);
    }
}
