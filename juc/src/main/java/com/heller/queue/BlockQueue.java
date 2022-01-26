package com.heller.queue;

import java.util.concurrent.ArrayBlockingQueue;

public class BlockQueue {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(3);
        //抛出异常
        queue.add(1);
        queue.remove();
        //特殊值
        queue.offer(1);
        queue.poll();
        //阻塞
        queue.put(1);
        queue.take();
    }
}
