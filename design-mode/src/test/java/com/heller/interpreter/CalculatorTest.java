package com.heller.interpreter;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class CalculatorTest {
    @Test
    public void test() {
        Calculator calculator = new Calculator("1-1-2");
        HashMap<String, Integer> map = new HashMap<>();
        map.put("1", 1);
        map.put("1", 1);
        map.put("2", 2);
        int run = calculator.run(map);
        System.out.println(run);
    }
}