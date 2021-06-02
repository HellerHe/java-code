package com.heller.datastructures.stack;

public class ArrayStack {
    private int max;
    private int[] stack;
    private int top = -1;

    public ArrayStack(int max) {
        this.max = max;
        stack = new int[max];
    }

    public boolean isFull() {
        return top == max-1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int value) {
        if (isFull()) {
            throw new RuntimeException("栈满");
        }
        top++;
        stack[top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        int v = stack[top];
        top--;
        return v;
    }

    public void list() {
        if (isEmpty()) {
            System.out.println("栈空");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }
}
