package com.example.test.myiotest;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class NIOClient {

    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("127.0.0.1", 8888);
        OutputStream out = socket.getOutputStream();
        //Thread.sleep(10000);
        String s = "hello go";
        out.write(s.getBytes());
        out.close();
    }
}

