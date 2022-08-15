package com.heller.threadlocal;

/**
 * ThreadLocal：每个Thread内有自己的实例副本且该副本只由当前线程自己使用；统一设置初始值,但是每个线程对这个值的修改都是各自线程互相独立的
 * 空间换时间
 * 为什么源代码ThreadLocalMap中Entry用弱引用？
 * 栈帧销毁强引用threadlocal后，ThreadLocalMap里某个entry的key引用还指向这个对象，若是强引用不能被gc回收，造成内存泄漏，
 * 若是弱引用就大概率会减少内存泄漏的问题，就可以使ThreadLocal对象在方法执行完毕后顺利被回收且Entry的key引用指向为null。
 * 但是如果线程迟迟不结束，需要ThreadLocalMap调用get、set时发现key为null时才会去回收整个entry、value，
 * 因此需要手动调用**remove**，尤其是线程池中，因为线程重复使用，后面使用者可能获取上个线程遗留的value。
 */
public class ThreadLocal {
    public static void main(String[] args) {
        Calc calc = new Calc();
        for (int i = 0; i < 3; i++) {
            int finalI = i;
            new Thread(()->{
                for (int j = 0; j < finalI + 3; j++) {
                    calc.add();
                }
                System.out.println(Thread.currentThread().getName()+":"+calc.threadLocal.get());
                calc.threadLocal.remove();
            }, String.valueOf(i)).start();
        }
    }

    static class Calc{
        java.lang.ThreadLocal<Integer> threadLocal = java.lang.ThreadLocal.withInitial(()->0);

        public void add() {
            threadLocal.set(threadLocal.get() + 1);
        }
    }
}
