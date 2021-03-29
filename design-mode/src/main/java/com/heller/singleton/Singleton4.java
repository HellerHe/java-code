package com.heller.singleton;

/**
 * ----双重检查
 * 1.实例化代码只用执行一次，后面再次访问，判断 if (singleton == null)直接return，避免反复进行方法同步
 * 2.线程安全，延迟加载，效率高
 * 3.推荐
 */
public class Singleton4 {
    private static volatile Singleton4 instance;
    private Singleton4(){}

    public static synchronized Singleton4 getInstance() {
        if (instance == null) {
            synchronized (Singleton4.class) {   //只有一个线程进入执行
                if (instance == null) {
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }
}
