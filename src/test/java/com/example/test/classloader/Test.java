package com.example.test.classloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {

        File file = new File("d:/TestClass.class");
        FileInputStream inputStream = new FileInputStream(file);
        byte [] bytes  = new byte[inputStream.available()];
        inputStream.read(bytes);
        inputStream.close();
        String execute = JavaclassExecuter.execute(bytes);
        System.out.println(execute);
    }
}
