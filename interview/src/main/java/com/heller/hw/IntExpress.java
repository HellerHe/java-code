package com.heller.hw;

/**
 * 计算该整数有几种连续自然数之和的表达式并打印出每一种表达式
 * 1.该整数的所有表达式和表达式的个数如果有多种表达式，自然数个数最少的表达式优先输出
 * 2.每个表达式中按自然数递增输出
 */
public class IntExpress {
    public static void main(String[] args) {
        run(99);
    }

    private static void run(int num) {
        int count = 0;
        for (int i = num; i >0 ; i--) {
            int sum = 0;
            String str = "";
            for (int j = i; j >0; j--) {
                sum += j;
                str = str + "+" + j;
                if (sum == num) {
                    count++;
                    System.out.println(num+"="+str.substring(1, str.length()));
                    break;
                } else if (sum > num) {
                    break;
                }
            }
        }
        System.out.println("Result:" + count);
    }
}
