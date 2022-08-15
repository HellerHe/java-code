package com.heller.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 异步编程：多个任务异步回调
 * CompletionStage 计算阶段
 * 获得结果和触发计算：get getNow join complete
 * 对计算结果进行处理：thenApply handle whenComplete
 * 对计算结果进行消费：thenRun thenAccept thenApply
 * 对计算速度进行选用：applyToEither acceptEither runAfterEither
 * 对计算结果进行合并：thenCombine thenAcceptBoth runAfterBoth
 * 多任务组合：allof anyof
 */
public class Completable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> runAsync = CompletableFuture.runAsync(() -> {
            System.out.println("无返回结果");
        });
        System.out.println(runAsync.get());

        CompletableFuture<Integer> supplyAsync = CompletableFuture.supplyAsync(() -> {
            System.out.println("有返回结果");
            return 1;
        }).thenApply(result -> result+1) //有依赖关系，两个线程串行
                .whenComplete((result, e) -> { //正常处理
                    if (e == null) {
                        System.out.println(Thread.currentThread().getName() + " result: " + result);
                    }
                })
                .exceptionally(e->{ //异常处理
                    e.printStackTrace();
                    return null;
                });
        System.out.println(supplyAsync.join());
    }
}
