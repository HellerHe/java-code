package com.heller.bridge;

/**
 * ----桥接模式
 * 桥接模式替代多层继承方案，可以减少子类的个数，降低系统的管理和维护成本
 * 对于那些不希望使用继承或因为多层次继承导致系统类的个数急剧增加的系统，桥接模式尤为适用
 */
public class FoldedPhone extends Phone{
    public FoldedPhone(Brand brand) {
        super(brand);
    }

    @Override
    void open() {
        super.open();
        System.out.println("翻盖手机");
    }

    @Override
    void close() {
        super.close();
        System.out.println("翻盖手机");
    }

    @Override
    void call() {
        super.call();
        System.out.println("翻盖手机");
    }
}
