package com.heller.facade;

public class Screen {
    private static volatile Screen instance;

    private Screen() {

    }

    public static synchronized Screen getInstance() {
        if (instance == null) {
            synchronized (Screen.class) {
                if (instance == null) {
                    instance = new Screen();
                }
            }
        }
        return instance;
    }

    public void down() {
        System.out.println("screen down");
    }

    public void up() {
        System.out.println("screen up");
    }
}
