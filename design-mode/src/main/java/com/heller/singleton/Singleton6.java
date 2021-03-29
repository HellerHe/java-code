package com.heller.singleton;

/**
 * ----枚举
 */
public class Singleton6 {

    enum Singleton {
        INSTANCE;
        public void sayOK() {
            System.out.println("ok~");
        }

    }
}
