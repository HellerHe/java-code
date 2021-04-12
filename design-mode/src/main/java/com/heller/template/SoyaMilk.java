package com.heller.template;

/**
 * ----模板方法模式
 * 一个抽象类公开定义了执行它的方法的模板。它的子类可以按需要重写方法实现，但调用将以抽象类中定义的方式进行
 * 一般模板方法都加上 final 关键字， 防止子类重写模板方法
 */
public abstract class SoyaMilk {
    final void make() {
        select();
        if (customerWantCondiments()) {
            addCondiments();
        }
        soak();
        beat();
    }

    void select() {
        System.out.println("第一步：选择好的新鲜黄豆 ");
    }

    abstract void addCondiments();

    void soak() { System.out.println("第三步， 黄豆和配料开始浸泡， 需要 3 小时 "); }
    void beat() { System.out.println("第四步：黄豆和配料放到豆浆机去打碎 "); }

    //钩子方法
    boolean customerWantCondiments() {
        return true;
    }
}
