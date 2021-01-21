package com.example.test.io;


import org.apache.geronimo.mail.util.Base64;
import org.apache.geronimo.mail.util.Base64Encoder;

import java.io.*;


public class Base64Test {

    public static void main(String[] args) throws IOException {

        File file = new File("D:\\zyf\\111.jpg");
        FileInputStream inputStream = new FileInputStream(file);
        BufferedInputStream buffered = new BufferedInputStream(inputStream);
        byte[] buff = new byte[/*inputStream.available()*/1024];
        int len = 0;

        while ( (len = buffered.read(buff)) != -1){

            byte[] encode = Base64.encode(buff, 0, len);
            System.out.println(new String(encode,"UTF-8"));

        }

    }
}
