package com.heller;

import java.lang.ref.SoftReference;

public class StringBuild {
    public static void main(String[] args) {
        SoftReference<Object> softReference = new SoftReference<Object>(1);
        Object o = softReference.get();
        System.out.println(o);
    }
}
