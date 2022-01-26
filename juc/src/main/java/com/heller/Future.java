package com.heller;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * + 主线程中耗时长的部分交给future，需要时在获取
 * + get方法计算完获取，否则一直阻塞
 * + 只计算一次
 */
public class Future {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(()->{
            return 1;
        });

        new Thread(futureTask, "a").run();
        System.out.println(futureTask.get());
        System.out.println(futureTask.get());
    }
}
