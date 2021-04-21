package com.heller.visitor;

public class Wait implements Action {
    @Override
    public void getManResult(Man man) {
        System.out.println("男 评价等待");
    }

    @Override
    public void getWomanResult(Woman woman) {
        System.out.println("女 评价等待");
    }
}
