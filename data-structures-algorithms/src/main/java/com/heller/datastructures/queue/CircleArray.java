package com.heller.datastructures.queue;

/**
 * 环形队列
 * (rear + 1) % max
 */
public class CircleArray {
    private int max;
    private int front = 0;
    private int rear = 0;
    private int[] arr;

    public CircleArray(int max) {
        this.max = max;
        arr = new int[max];
    }

    public boolean isFull() {
        return (rear + 1) % max == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void add(int n) {
        if (isFull()) {
            System.out.println("队列满，不能加入数据~");
        }
        arr[rear] = n;
        //将 rear 后移, 这里必须考虑取模
        rear = (rear + 1) % max;
    }

    public int take() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，不能取数据");
        }
        int value = arr[front];
        front = (front + 1) % max;
        return value;
    }

    //有效数据个数
    public int size() {
        return (rear + max - front) % max;
    }

    public void show() {
        for (int i = front; i < front + size(); i++) {
            System.out.print("\t" + arr[i % max]);
        }
    }

    public int head() {
        if (isEmpty()) {
            throw new RuntimeException("队列空的，没有数据~~");
        }
        return arr[front];
    }
}
