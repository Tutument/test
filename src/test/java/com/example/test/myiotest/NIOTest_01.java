package com.example.test.myiotest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 磁盘nio测试
 */
public class NIOTest_01 {


    public static void main(String[] args) throws IOException {
        fastCopy("D:\\data\\a.txt","D:\\data\\b.txt");
    }

    public static void fastCopy(String srcouce, String target) throws IOException {

        FileInputStream inputStream = new FileInputStream (srcouce);
        FileChannel inputChannel = inputStream.getChannel();

        FileOutputStream outputStream = new FileOutputStream(target);
        FileChannel outputChannel = outputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
        while (true){
            int read = inputChannel.read(byteBuffer);

            if(read == -1){
                break;
            }
            /* 切换读写 */
            byteBuffer.flip();

            outputChannel.write(byteBuffer);

            byteBuffer.clear();
        }

    }
}
