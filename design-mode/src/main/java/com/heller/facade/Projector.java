package com.heller.facade;

public class Projector {
    private static Projector instance = new Projector();

    private Projector() {

    }

    public static Projector getInstance() {
        return instance;
    }

    public void on() {
        System.out.println("projector on");
    }

    public void focus() {
        System.out.println("projector focus");
    }

    public void off() {
        System.out.println("projector off");
    }
}
