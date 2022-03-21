package com.heller.hw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *利用当前出现过的数字，构造下一个距离当前时间最近的时刻
 * 18:52 => 18:55
 * 23:59 => 22:22
 */
public class DcodeTime {
    public static void main(String[] args) {
        System.out.println(decode("23:59"));
    }

    private static String decode(String time) {
        String str = "";
        String[] HM = time.split(":");
        int H = Integer.parseInt(HM[0]);
        int M = Integer.parseInt(HM[1]);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < time.length(); i++) {
            if (time.charAt(i) != ':') {
                list.add(Integer.valueOf(String.valueOf(time.charAt(i))));
            }
        }
        List<Integer> multi = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(i) < 6) {
                    multi.add(list.get(i) * 10 + list.get(j));
                }
            }
        }
        Collections.sort(multi);
        if (H != 23) {
            for (Integer num : multi) {
                if (num <= M) {
                    continue;
                }
                str = H + ":" + num;
                break;
            }
        } else {
            str = multi.get(0) + ":" + multi.get(0);
        }
        return str;
    }
}
