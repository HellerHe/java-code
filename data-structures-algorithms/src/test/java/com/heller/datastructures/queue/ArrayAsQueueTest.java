package com.heller.datastructures.queue;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayAsQueueTest {
    @Test
    public void test() {
        ArrayAsQueue queue = new ArrayAsQueue(10);
        System.out.println(queue.isEmpty());
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        System.out.println(queue.isEmpty());
        System.out.println(queue.isFull());
        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.head());

        queue.show();
    }
}