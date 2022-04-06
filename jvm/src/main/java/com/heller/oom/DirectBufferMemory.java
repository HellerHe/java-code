package com.heller.oom;

import java.nio.ByteBuffer;

import static sun.misc.VM.maxDirectMemory;

/**
 * java.lang.OutOfMemoryError: Direct buffer memory
 */
public class DirectBufferMemory {
    public static void main(String[] args) {
        System.out.println("配置的maxDirectMemory：" + maxDirectMemory()/1024/1024 + "mb");
        //分配堆外直接内存
        ByteBuffer.allocateDirect(6 * 1026 * 1026);
    }
}
