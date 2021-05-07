package com.heller.datastructures.queue;

/**
 * 使用数组模拟队列
 */
public class ArrayAsQueue {
    private int max;
    private int front = -1;
    private int rear = -1;
    private int[] arr;

    public ArrayAsQueue(int max) {
        this.max = max;
        arr = new int[max];
    }

    public boolean isFull() {
        return front + 1 == max;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void add(int n) {
        if (isFull()) {
            System.out.println("队列满，不能加入数据~");
        } else {
            rear++;
            arr[rear] = n;
        }
    }

    public int take() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，不能取数据");
        } else {
            front++;
            return arr[front];
        }
    }

    public void show() {
        for (int data : arr) {
            System.out.print("\t" + data);
        }
    }

    public int head() {
        if (isEmpty()) {
            throw new RuntimeException("队列空的，没有数据~~");
        } else {
            return arr[front + 1];
        }
    }
}
