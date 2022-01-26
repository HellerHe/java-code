package com.heller.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 异步编程
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
        });
        System.out.println(supplyAsync.get());
    }
}
