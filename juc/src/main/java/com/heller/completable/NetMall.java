package com.heller.completable;

import com.google.common.base.Stopwatch;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * 商城比价：异步获取多个商城商品价格
 */
public class NetMall {
    static List<Mall> malls = Arrays.asList(new Mall("jd"), new Mall("taobao"), new Mall("pdd"));

    public List<Double> getPriceByStep(List<Mall> malls, String product) {
        return malls.stream().map(mall -> mall.calcPrice(product)).collect(Collectors.toList());
    }

    public List<Double> getPriceByAsync(List<Mall> malls, String product) {
        return malls.stream()
                .map(mall ->  CompletableFuture.supplyAsync(() -> mall.calcPrice(product)))
                .collect(Collectors.toList())
                .stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }

    static class Mall{
        private String name;

        public Mall(String name) {
            this.name = name;
        }

        public double calcPrice(String product) {
            try {Thread.sleep(1000);} catch (InterruptedException e) {throw new RuntimeException(e);}
            return ThreadLocalRandom.current().nextDouble() + product.charAt(0);
        }
    }

    public static void main(String[] args) {
        NetMall netMall = new NetMall();
        Stopwatch stopwatch = Stopwatch.createStarted();
        netMall.getPriceByStep(malls, "shoe").forEach(System.out::println);
        stopwatch.stop();
        System.out.println("分步获取耗时：" + stopwatch.elapsed());
        stopwatch.reset().start();
        netMall.getPriceByAsync(malls, "shoe").forEach(System.out::println);
        stopwatch.stop();
        System.out.println("异步获取耗时：" + stopwatch.elapsed());
    }
}
