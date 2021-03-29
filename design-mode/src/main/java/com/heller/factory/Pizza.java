package com.heller.factory;

public class Pizza {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void prepare(){
        System.out.println("准备");
    }

    public void bake() {
        System.out.println("烘焙");
    }

    public void cut() {
        System.out.println("切割");
    }

    public void box() {
        System.out.println("打包");
    }
}
