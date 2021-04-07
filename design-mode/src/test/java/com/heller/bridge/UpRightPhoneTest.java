package com.heller.bridge;


import org.junit.Test;

public class UpRightPhoneTest {
    @Test
    public void test() {
        UpRightPhone upRightPhone = new UpRightPhone(new Xiaomi());
        upRightPhone.open();
        upRightPhone.call();
        upRightPhone.close();
        System.out.println("---------");

        FoldedPhone foldedPhone = new FoldedPhone(new Huawei());
        foldedPhone.open();
        foldedPhone.call();
        foldedPhone.close();
    }
}