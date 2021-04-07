package com.heller.builder;

public class CommonHouse extends HouseBuilder{
    @Override
    public void buildBasic() {
        System.out.println("普通房子地基5m");
    }

    @Override
    public void buildWalls() {
        System.out.println("普通房子砌墙4m");
    }

    @Override
    public void roofed() {
        System.out.println("普通房子屋顶");
    }
}
