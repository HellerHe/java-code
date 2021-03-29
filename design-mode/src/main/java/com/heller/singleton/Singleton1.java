package com.heller.singleton;

/**
 * ----饿汉式（静态常量）
 * 1.构造器私有化（防止 new）
 * 2.类内部创建对象
 * 3.暴露一个静态的公共方法
 *
 * 优点：写法简单，就是在类装载的时候就完成实例化，避免了线程同步问题。
 * 缺点：基于classloder机制，没有达到Lazy Loading的效果，如果未使用这个实例会造成内存的浪费。
 */
public class Singleton1 {
    private static final Singleton1 instance = new Singleton1();

    private Singleton1() {}

    public static Singleton1 getInstance() {
        return instance;
    }
}
