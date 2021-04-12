package com.heller.facade;

public class TheaterLight {
    private static TheaterLight instance = new TheaterLight();

    private TheaterLight() {

    }

    public static TheaterLight getInstance() {
        return instance;
    }

    public void on() {
        System.out.println("TheaterLight on");
    }

    public void dim() {
        System.out.println("TheaterLight dim...");
    }

    public void bright() {
        System.out.println("TheaterLight bright...");
    }

    public void off() {

    }
}
