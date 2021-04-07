package com.heller.builder;

public class HighHouse extends HouseBuilder{
    @Override
    public void buildBasic() {
        System.out.println("高楼地基100m");
    }

    @Override
    public void buildWalls() {
        System.out.println("高楼墙100m");
    }

    @Override
    public void roofed() {
        System.out.println("高楼透明屋顶");
    }
}
