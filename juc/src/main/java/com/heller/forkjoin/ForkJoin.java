package com.heller.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * 分支合并
 *
 * RecursiveAction 没有返回结果
 * RecursiveTask 有返回结果，递归
 * 通过ForkJoinPool.submit提交任务
 */
public class ForkJoin extends RecursiveTask<Integer> {
    private int start;
    private int end;
    private int value;

    public ForkJoin(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start <= 9) {
            System.out.println(start + "-" + end + "累加开始");
            for (int i = start; i <= end; i++) {
                value += i;
            }
        } else {
            int mid = start + 9;
            ForkJoin task1 = new ForkJoin(start, mid);
            ForkJoin task2 = new ForkJoin(mid + 1, end);
            task1.fork();
            task2.fork();
            value = task1.join() + task2.join();
        }
        return value;
    }

    public static void main(String[] args){
        ForkJoin forkJoin = new ForkJoin(1, 100);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> task = forkJoinPool.submit(forkJoin);
        try {
            System.out.println(task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            forkJoinPool.shutdown();
        }
    }
}
