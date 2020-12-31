package com.example.test.myiotest;

import java.io.*;
import java.net.URL;

public class IOTest {
    /**
     * 测试字符流和字节流的区别
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //字符流测试
        //reader();

        //字节流测试
        //inputStream();

        //java序列化测试
        //objectStream();

        url();
    }

    //字符流测试
    public static void reader() throws IOException {
        Reader reader = new FileReader("D:\\data\\io测试.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);
        int d = 0;
        while (d!=-1){
            d = reader.read();
           if(d>0){
               System.out.println(d);
           }
        }
        reader.close();
    }

    //字节流测试
    public static void inputStream() throws IOException {
        InputStream stream = new FileInputStream("D:\\data\\io测试.txt");
        int d = 0;
        while (d!=-1){
            d = stream.read();
            if(d>0){
                System.out.println(d);
            }
        }
        stream.close();
    }

    //java序列化测试
    public static void objectStream() throws IOException, ClassNotFoundException {

        A a1 = new A(123, "abc");
        String objectFile = "D:\\data\\io测试.txt";
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(objectFile));
        objectOutputStream.writeObject(a1);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(objectFile));
        A a2 = (A) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println(a2);
    }
    private static class A implements Serializable {
        private int x;
        private String y;

        A(int x, String y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "x = " + x + "  " + "y = " + y;
        }
    }

    //java url 统一资源定位符 测试
    public static void url() throws IOException {

        URL url = new URL("https://www.baidu.com");

        /* 字节流 */
        InputStream is = url.openStream();

        /* 字符流 */
        InputStreamReader isr = new InputStreamReader(is, "utf-8");

        /* 提供缓存功能 */
        BufferedReader br = new BufferedReader(isr);

        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
    }
}
