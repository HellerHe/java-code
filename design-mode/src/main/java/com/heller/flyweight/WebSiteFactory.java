package com.heller.flyweight;

import java.util.HashMap;

/**
 * ----享元模式
 * 注意划分内部状态和外部状态，并且需要有一个工厂类加以控制。
 * 应用场景就是池技术：String 常量池、数据库连接池、缓冲池等。
 */
public class WebSiteFactory {
    private HashMap<String, ConcreteWebSite> pool = new HashMap<>();

    public WebSite createWebSite(String type) {
        if (!pool.containsKey(type)) {
            pool.put(type, new ConcreteWebSite(type));
        }
        return pool.get(type);
    }

    public int count() {
        return pool.size();
    }
}
