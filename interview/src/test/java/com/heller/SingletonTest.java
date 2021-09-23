package com.heller;


import org.junit.jupiter.api.Test;

class SingletonTest {
    @Test
    public void test() {
        Singleton instance = Singleton.getInstance();
    }
}