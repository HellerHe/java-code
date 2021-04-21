package com.heller.mediator;

public class TV extends Colleague{
    public TV(Mediator mediator, String name) {
        super(mediator, name);
        mediator.register(name, this);
    }

    @Override
    public void sendMessage(int state) {
        this.getMediator().getMessage(state, name);
    }

    public void startTv() {
        System.out.println("start TV");
    }

    public void stopTv() {
        System.out.println("stop TV");
    }
}
