package com.heller.datastructures.recursion;

import org.junit.Test;

import static org.junit.Assert.*;

public class RecursionTest {
    @Test
    public void test() {
        Recursion.reduce(4);
        int factorial = Recursion.factorial(3);
        System.out.println(factorial);
    }

}