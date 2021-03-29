package com.heller.singleton;

/**
 * ----静态内部类
 * 1.调用getInstance方法，才会装载SingletonInstance类，从而完成Singleton的实例化
 * 2.类的静态属性只会在第一次加载类的时候初始化，所以在这里，JVM 帮助我们保证了线程的安全性，在类进行初始化时，别的线程是无法进入的。
 * 3.避免了线程不安全，利用静态内部类特点实现延迟加载，效率高
 * 4.推荐
 */
public class Singleton5 {
    private static volatile Singleton5 instance;

    private Singleton5(){}

    private static class SingletonInstance {
        public static final Singleton5 INSTANCE = new Singleton5();
    }

    public static synchronized Singleton5 getInstance() {
        return SingletonInstance.INSTANCE;
    }
}
