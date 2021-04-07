package com.heller.bridge;

public class UpRightPhone extends Phone{
    public UpRightPhone(Brand brand) {
        super(brand);
    }

    @Override
    void open() {
        super.open();
        System.out.println("直板手机");
    }

    @Override
    void close() {
        super.close();
        System.out.println("直板手机");
    }

    @Override
    void call() {
        super.call();
        System.out.println("直板手机");
    }
}
