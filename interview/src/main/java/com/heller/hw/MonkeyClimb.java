package com.heller.hw;

/**
 * 一个猴子在一座不超过30级的小山上爬山跳跃，猴子上山一步可跳1级或跳3级，试求上山有多少种不同的爬法
 * 1 1
 * 2 1
 * 3 2
 * 4 3
 * 5 4
 * 6 6
 * 7 9
 * k=(k-1) + (k-3)
 */
public class MonkeyClimb {
    public static void main(String[] args) {
        System.out.println(calc(30));
    }

    private static int calc(int step) {
        if (step == 1) {
            return 1;
        } else if (step == 2) {
            return 1;
        } else if (step == 3) {
            return 2;
        } else {
            return calc(step - 1) + calc(step - 3);
        }
    }
}
