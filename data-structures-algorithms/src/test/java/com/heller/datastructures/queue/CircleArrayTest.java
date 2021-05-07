package com.heller.datastructures.queue;

import org.junit.Test;

import static org.junit.Assert.*;

public class CircleArrayTest {
    @Test
    public void test() {
        CircleArray circleArray = new CircleArray(3);
        circleArray.add(1);
        circleArray.add(2);
        circleArray.show();
        System.out.println();
        circleArray.take();
        circleArray.add(3);
        circleArray.show();

    }
}