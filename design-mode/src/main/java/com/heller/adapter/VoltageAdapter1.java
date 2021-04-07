package com.heller.adapter;

/**
 * ----类适配器模式
 * 继承 src 类，要求 dst 必须是接口
 */
public class VoltageAdapter1 extends Voltage220V implements Voltage5V{

    @Override
    public int output5V() {
        return super.output220V() / 44;
    }
}
