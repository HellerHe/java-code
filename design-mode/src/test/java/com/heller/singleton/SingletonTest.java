package com.heller.singleton;

import org.junit.jupiter.api.Test;

public class SingletonTest {
    @Test
    public void getInstance() {
        Singleton5 instance1 = Singleton5.getInstance();
        Singleton5 instance2 = Singleton5.getInstance();
        System.out.println(instance1 == instance2);
    }
}