package com.heller.bridge;

public class Phone {
    private Brand brand;

    public Phone(Brand brand) {
        this.brand = brand;
    }

    void open() {
        brand.open();
    }

    void close() {
        brand.close();
    }

    void call() {
        brand.call();
    }
}
