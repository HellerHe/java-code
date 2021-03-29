package com.heller.singleton;

/**
 * ----懒汉式（线程不安全）
 * 1.起到了 Lazy Loading 的效果，但是只能在单线程下使用。
 * 2.多线程下，进入if判断会产生多个实例，不安全。
 * 3.不推荐
 */
public class Singleton2 {
    private static Singleton2 instance;

    private Singleton2() {}

    public static Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}
