package com.heller;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.WeakHashMap;

public class Reference {
    public static void main(String[] args) {
        //gc之后放到引用队列里边暂时保存
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        SoftReference<Object> softReference = new SoftReference<Object>(1, referenceQueue);
        WeakHashMap<String, String> weakHashMap = new WeakHashMap<>(); //弱引用，gc会直接清除内容
        PhantomReference<Object> objectPhantomReference = new PhantomReference<Object>(1, referenceQueue);
        Object o = softReference.get();
        System.out.println(o);
    }
}
