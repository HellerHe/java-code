package com.heller.singleton;

import com.heller.singleton.Singleton5;
import org.junit.Test;

public class SingletonTest {
    @Test
    public void getInstance() {
        Singleton5 instance1 = Singleton5.getInstance();
        Singleton5 instance2 = Singleton5.getInstance();
        System.out.println(instance1 == instance2);
    }
}