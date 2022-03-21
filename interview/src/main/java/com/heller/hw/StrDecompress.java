package com.heller.hw;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 如果字符重复次数一样，则根据ASCII编码顺序做升序排序
 * a3b2 => bbaaa
 * b2a2 => aabb
 */
public class StrDecompress {
    public static void main(String[] args) {
        System.out.println(decompress("a3b2"));
        System.out.println(decompress("b2a2"));
        System.out.println(decompress("a11b2bac3bad3abcd2"));
    }

    private static String decompress(String str) {
        StringBuilder result = new StringBuilder();

        String[] arr = str.split("\\d+");
        List<String> split = Arrays.stream(str.split("[a-z]")).filter(s->!s.isEmpty()).collect(Collectors.toList());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], Integer.valueOf(split.get(i)));
        }
        map.entrySet().stream().sorted(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (!o1.getValue().equals(o2.getValue())) {
                    return o1.getValue() - o2.getValue();
                } else {
                    return o1.getKey().compareTo(o2.getKey());
                }
            }
        }).forEach(kv->{
            for (int i = 0; i < kv.getValue(); i++) {
                result.append(kv.getKey()) ;
            }
        });
        return result.toString();
    }
}
