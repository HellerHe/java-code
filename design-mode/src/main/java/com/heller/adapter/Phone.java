package com.heller.adapter;

public class Phone {
    public void charging(Voltage5V v) {
        if (v.output5V() == 5) {
            System.out.println("5V,可以充电");
        } else {
            System.out.println("不匹配电压，不能充电");
        }
    }
}
