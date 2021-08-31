package com.heller.datastructures.recursion;

import org.junit.jupiter.api.Test;

public class RecursionTest {
    @Test
    public void test() {
        Recursion.reduce(4);
        int factorial = Recursion.factorial(3);
        System.out.println(factorial);
    }

}