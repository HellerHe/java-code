package com.heller.adapter;

import org.junit.Test;

public class VoltageAdapterTest {
    @Test
    public void adapterTest() {
        Phone phone = new Phone();
        phone.charging(new VoltageAdapter1());
        phone.charging(new VoltageAdapter2(new Voltage220V()));
    }

    @Test
    public void adsAdapterTest() {
        AbsAdapter absAdapter = new AbsAdapter(){
            @Override
            public void m1() {
                System.out.println("重写m1方法");
            }

            @Override
            public void m5() {

            }
        };
    }
}