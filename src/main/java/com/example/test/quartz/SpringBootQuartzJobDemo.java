package com.example.test.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class SpringBootQuartzJobDemo implements Job {

    //@Autowired
    CommonsUtil4Quartz commonsUtil4Quartz;// 用于模拟任务中的业务对象。 也可能是数据访问对象，或其他类型的对象。

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("commonsUtil4Quartz: "+ DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()));
        this.commonsUtil4Quartz.testMethod();
    }
}
