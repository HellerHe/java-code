package com.heller.queue;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ProdConsumerWithBlockQueue {
    public static void main(String[] args) throws InterruptedException {
        Resource resource = new Resource(new ArrayBlockingQueue(10));
        new Thread(()->{
            try {
                resource.prod();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "prod").start();

        new Thread(()->{
            try {
                resource.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "consumer").start();

        TimeUnit.SECONDS.sleep(5);
        resource.stop();

    }
}

class Resource {
    private volatile boolean flag = true;
    private BlockingQueue<Integer> queue;
    private AtomicInteger resource = new AtomicInteger();

    public Resource(BlockingQueue queue) {
        this.queue = queue;
        System.out.println(queue.getClass().getName());
    }

    public void prod() throws InterruptedException {
        while (flag) {
            int i = resource.incrementAndGet();
            if (queue.offer(i)) {
                System.out.println(Thread.currentThread().getName() + "\t" + i + "插入队列成功");
            } else {
                System.out.println(Thread.currentThread().getName() + "\t" + i + "插入队列失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName() + "\t停止生产");
    }

    public void consumer() throws InterruptedException {
        while (flag) {
            Integer value = queue.poll(2L, TimeUnit.SECONDS);
            if (value != null) {
                System.out.println(Thread.currentThread().getName() + "\t" + value + "消费成功");
            } else {
                System.out.println(Thread.currentThread().getName() + "\t" + "超出2s取不到，消费退出");
                flag = false;
                break;
            }
        }
    }

    public void stop() {
        flag = false;
    }
}