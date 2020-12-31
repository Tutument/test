package com.example.test.jdk8Time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TimeTest {
    static DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyyMMdd:HHmmss");

    public static void main(String[] args) {

        //dateToString();
        //dateToStringNew();
        //stringToDate();
        //stringToDateNew();
        test();
    }

    public static void test(){
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime after = now.plusMinutes(6);
        String dateStr = now.format(pattern) + after.format(pattern);
        System.out.println(dateStr);
    }
    //Date转String
    public static void dateToString(){
        //使用Date和SimpleDateFormat
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("G yyyy年MM月dd号 E a hh时mm分ss秒");
        String format = simpleDateFormat.format(new Date());
        System.out.println(format);
        //打印: 公元 2017年03月21号 星期二 下午 06时38分20秒
    }

    public static void dateToStringNew(){
        //使用jdk1.8 LocalDateTime和DateTimeFormatter
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime localDateTime = now.plusMinutes(6);
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyyMMdd:HHmmss");
        String format = now.format(pattern);
        String f = localDateTime.format(pattern);
        System.out.println(format);
        System.out.println(f);
        //打印: 公元 2017年03月21号 星期二 下午 06时38分20秒
    }



    //
    public static void stringToDate(){
        //使用Date和SimpleDateFormat
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = null;
        try {
            date = simpleDateFormat.parse("2017-12-03 10:15:30");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(simpleDateFormat.format(date));
        //打印 2017-12-03 10:15:30
    }

    public static void stringToDateNew(){
        //使用jdk1.8 LocalDateTime和DateTimeFormatter
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //严格按照ISO yyyy-MM-dd验证，03写成3都不行
        LocalDateTime dt = LocalDateTime.parse("2017-12-03 10:15:30",pattern);
        System.out.println(dt.format(pattern));
    }

}
