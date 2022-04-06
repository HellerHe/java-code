package com.heller;

public class Singleton {
    //volatitle保证同步性不保证原子性
    private static volatile Singleton instance;
    //防止new
    private Singleton(){}

    public static Singleton getInstance() {
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
