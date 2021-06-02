package com.heller.datastructures.recursion;

public class Recursion {
    public static void reduce(int n) {
        if (n > 1) {
            reduce(n - 1);
        } else {
            System.out.println(n);
        }
    }

    public static int factorial(int n) {
        if (n > 1) {
            return factorial(n - 1) * n;
        } else {
            return n;
        }
    }
}
