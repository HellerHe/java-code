package com.heller.bridge;

public class Huawei implements Brand{
    @Override
    public void open() {
        System.out.println("华为手机打开");
    }

    @Override
    public void close() {
        System.out.println("华为手机关闭");
    }

    @Override
    public void call() {
        System.out.println("华为手机打电话。。。");
    }
}
