package com.heller.queue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * ArrayBlockingQueue
 * LinkedBlockingQueue 默认容量 Integer.MAX_VALUE
 * SynchronousQueue 单个元素
 * PriorityBlockingQueue 支持优先级排序的无界阻塞队列
 *
 * add      offer   put
 * remove   poll    take
 * element  peek
 */
public class BlockQueue {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(3);
        //抛出异常
        queue.add(1);
        queue.remove();
        Integer element = queue.element();
        //特殊值
        queue.offer(1);
        queue.poll();
        Integer peek = queue.peek();
        //阻塞
        queue.put(1);
        queue.take();
    }
}
