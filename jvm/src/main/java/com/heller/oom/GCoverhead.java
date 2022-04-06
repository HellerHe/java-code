package com.heller.oom;

import java.util.ArrayList;

/**
 * java.lang.OutOfMemoryError: GC overhead limit exceeded
 */
public class GCoverhead {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        try {
            while (true) {
                list.add(i++);
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
