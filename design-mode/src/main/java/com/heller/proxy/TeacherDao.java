package com.heller.proxy;

public class TeacherDao implements Teacher{
    @Override
    public void teach() {
        System.out.println("授课中。。。");
    }
}
