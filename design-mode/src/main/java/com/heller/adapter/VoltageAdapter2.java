package com.heller.adapter;

/**
 * ----对象适配器模式
 */
public class VoltageAdapter2 implements Voltage5V{
    private Voltage220V voltage220V;

    public VoltageAdapter2(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }

    @Override
    public int output5V() {
        int dst = 0;
        if (voltage220V != null) {
            dst = voltage220V.output220V() / 44;
        }
        return dst;
    }
}
