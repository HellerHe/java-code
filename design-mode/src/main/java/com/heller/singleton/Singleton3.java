package com.heller.singleton;

/**
 * ----懒汉式（线程安全）
 * 1.加入同步处理的代码，解决线程安全问题
 * 2.效率太低，每个线程都要同步
 * 3.不推荐
 */
public class Singleton3 {
    private static Singleton3 instance;

    private Singleton3() {}

    public static synchronized Singleton3 getInstance() {
        if (instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }
}
