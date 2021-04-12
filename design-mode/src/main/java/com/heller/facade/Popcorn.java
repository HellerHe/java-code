package com.heller.facade;

public class Popcorn {
    private static volatile Popcorn instance;
    private Popcorn() {

    }

    public static synchronized Popcorn getInstance() {
        if (instance == null) {
            synchronized (Popcorn.class) {
                if (instance == null) {
                    instance = new Popcorn();
                }
            }
        }
        return instance;
    }

    public void on() {
        System.out.println("popcorn on");
    }

    public void pop() {
        System.out.println("popcorn pop");
    }

    public void off() {
        System.out.println("popcorn off");
    }
}
