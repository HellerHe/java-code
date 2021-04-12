package com.heller.facade;

public class DVDPlayer {
    private static DVDPlayer instance = new DVDPlayer();

    private DVDPlayer() {

    }

    public static DVDPlayer getInstance() {
        return instance;
    }

    public void on() {
        System.out.println("DVD on");
    }

    public void play() {
        System.out.println("DVD play");
    }

    public void pause() {
        System.out.println("DVD pause");
    }

    public void off() {
        System.out.println("DVD off");
    }
}
