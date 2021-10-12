package com.heller.algorithms.common;

/**
 * ----分治法
 */
public class Hanoitower {
    public void run(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println("第1个盘从 " + a + "->" + c);
        } else {
            run(num - 1, a, c, b);
            System.out.println("第" + num + "个盘从 " + a + "->" + c);
            run(num-1, b, a, c);
        }
    }

    public static void main(String[] args) {
        Hanoitower hanoitower = new Hanoitower();
        hanoitower.run(4, 'a', 'b', 'c');
    }
}
