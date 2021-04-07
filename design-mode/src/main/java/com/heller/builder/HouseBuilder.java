package com.heller.builder;

/**
 * ----建造者模式
 * Product，Builder，ConcreteBuilder，Director
 * 1.产品本身与产品的创建过程解耦
 * 2.增加新的具体建造者无须修改原有类库的代码，指挥者类针对抽象建造者类编程
 * 3.如果产品之间的差异性很大，则不适合使用建造者模式
 */
public abstract class HouseBuilder {
    public abstract void buildBasic();

    public abstract void buildWalls();

    public abstract void roofed();

    public House build() {
        buildBasic();
        buildWalls();
        roofed();
        return new House();
    }
}
