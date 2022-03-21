package com.heller.hw;

/**
 * 特定大小的停车场，数组cars[]表示，其中1表示有车，0表示没车。
 * 车辆大小不一，小车占一个车位（长度1），货车占两个车位（长度2），卡车占三个车位（长度3）。
 * 统计停车场最少可以停多少辆车，返回具体的数目。
 * 1,1,0,0,1,1,1,0,1 => 3
 */
public class CarStatic {
    public static void main(String[] args) {
        char[] ch = {1, 1, 0, 0, 1, 1, 1, 0, 1};
        System.out.println(get(ch));

    }

    private static int get(char[] ch) {
        int num = 0;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == 1) {
                num++;
                for (int j = i+1; j <ch.length; j++) {
                    if (ch[j] == 0) {
                        break;
                    }
                    i = j;
                }
            }
        }
        return num;
    }
}
