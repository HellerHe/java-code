package com.heller.mediator;

public interface Mediator {
    void register(String name, Colleague colleague);

    void getMessage(int state, String name);

    void sendMessage();
}
