package com.heller;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * + 主线程中耗时长的部分交给future，需要时在获取
 * + get方法计算完获取，否则一直阻塞
 * + 相同任务只计算一次
 */
public class Future {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                TimeUnit.SECONDS.sleep(5);
                return 1;
            }
        });
        new Thread(futureTask, "a").start();

        int num = 100;
        while (!futureTask.isDone()) {
            //future 正在运行，没有callable
        }
        Integer integer = futureTask.get();
        System.out.println(num+integer);
    }
}
