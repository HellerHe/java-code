package com.heller.algorithms.common;

import com.google.common.collect.Sets;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * ----贪心算法
 * 在每一步选择中都采取最好或者最优(即最有利)的选择
 * 贪婪算法所得到的结果不一定是最优的结果(有时候会是最优解)，但是都是相对近似(接近)最优解的结果
 */
public class Greedy {
    public static void main(String[] args) {
        HashMap<String, HashSet<String>> broadcasts = new HashMap<>();
        HashSet<String> hashSet1 = new HashSet<String>();
        hashSet1.add("北京"); hashSet1.add("上海"); hashSet1.add("天津");
        HashSet<String> hashSet2 = new HashSet<String>();
        hashSet2.add("广州"); hashSet2.add("北京"); hashSet2.add("深圳");
        HashSet<String> hashSet3 = new HashSet<String>();
        hashSet3.add("成都"); hashSet3.add("上海"); hashSet3.add("杭州");
        HashSet<String> hashSet4 = new HashSet<String>();
        hashSet4.add("上海"); hashSet4.add("天津");
        HashSet<String> hashSet5 = new HashSet<String>();
        hashSet5.add("杭州"); hashSet5.add("大连");
        broadcasts.put("K1", hashSet1); broadcasts.put("K2", hashSet2); broadcasts.put("K3", hashSet3); broadcasts.put("K4", hashSet4); broadcasts.put("K5", hashSet5);
        HashSet<String> areas = Sets.newHashSet("北京", "上海", "天津", "广州", "深圳", "成都", "杭州", "大连");

        HashSet<String> tmp = Sets.newHashSet();
        while (areas.size() != 0) {
            String max = null;
            for (Map.Entry<String, HashSet<String>> entry : broadcasts.entrySet()) {
                String k = entry.getKey();
                HashSet<String> broadcast = entry.getValue();
                tmp.clear();
                tmp.addAll(broadcast);
                //交集
                tmp.retainAll(areas);
                //核心：tmp.size()>0去掉已经添加过的set；max == null添加第一个k；循环一遍取最多包含的set
                if (tmp.size()>0 && (max == null || (tmp.size() > broadcasts.get(max).size()))) {
                    max = k;
                }
            }
            if (max != null) {
                System.out.println(max);
                areas.removeAll(broadcasts.get(max));
            }
        }
    }
}
