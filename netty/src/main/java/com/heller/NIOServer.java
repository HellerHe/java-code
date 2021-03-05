package com.heller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class NIOServer {
    public static void main(String[] args) throws IOException {
        //writeFile();
        //readFile();
        //copy();
        transfer();
    }

    private static void writeFile() throws IOException {
        FileOutputStream outputStream = new FileOutputStream("./b.txt");
        FileChannel fileChannel = outputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put("qqq".getBytes(StandardCharsets.UTF_8));
        byteBuffer.flip();
        fileChannel.write(byteBuffer);

        outputStream.close();
    }

    private static void readFile() throws IOException {
        File file = new File("./a.txt");
        FileInputStream inputStream = new FileInputStream(file);
        FileChannel inputStreamChannel = inputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());
        inputStreamChannel.read(byteBuffer);
        System.out.println(new String(byteBuffer.array()));
        inputStream.close();
    }

    private static void copy() throws IOException {
        FileInputStream inputStream = new FileInputStream("./a.txt");
        FileChannel inputStreamChannel = inputStream.getChannel();
        FileOutputStream outputStream = new FileOutputStream("./b.txt");
        FileChannel outputStreamChannel = outputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (true) {
            byteBuffer.clear();
            int i = inputStreamChannel.read(byteBuffer);
            if (i == -1) {
                break;
            }
            byteBuffer.flip();
            outputStreamChannel.write(byteBuffer);
        }

        inputStream.close();
        outputStream.close();
    }

    private static void transfer() throws IOException {
        FileInputStream inputStream = new FileInputStream("./a.txt");
        FileChannel inputStreamChannel = inputStream.getChannel();
        FileOutputStream outputStream = new FileOutputStream("./b.txt");
        FileChannel outputStreamChannel = outputStream.getChannel();
        outputStreamChannel.transferFrom(inputStreamChannel, 0, inputStreamChannel.size());

        inputStreamChannel.close();
        outputStreamChannel.close();
        inputStream.close();
        outputStream.close();
    }

}
