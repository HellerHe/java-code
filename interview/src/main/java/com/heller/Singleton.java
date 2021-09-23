package com.heller;

public class Singleton {
    private static volatile Singleton instance;
    //防止new
    private Singleton(){}

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
