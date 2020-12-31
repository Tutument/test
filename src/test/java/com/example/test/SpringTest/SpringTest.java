package com.example.test.SpringTest;

import com.example.test.learn.manager.AsyncManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.TimerTask;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringTest {



    @Test
    public void test01(){

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);
        Person person = (Person)applicationContext.getBean("person");
        System.out.println(person);
    }

    @Test
    public void test02(){
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("线程：" + Thread.currentThread().getName());
                System.out.println("haha");
            }
        };
        AsyncManager.me().execute(task);
        System.out.println("线程：" + Thread.currentThread().getName());
        System.out.println("xixi");

    }
}
