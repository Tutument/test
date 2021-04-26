package com.example.test.transactionalTest;

import com.example.test.transactionalTest.entity.User;
import com.example.test.transactionalTest.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionalController {

    int i = 0;

    @Autowired
    UserMapper userMapper;
    //测试一下controller事务是否有效
    @RequestMapping("/testTr")
    @Transactional(rollbackFor = Exception.class)
    public String test(){
        User user = new User();
        try {
            user.setAge(18);
            user.setName("linda");
            user.setSex(1);
            userMapper.insert(user);
            i++;
            System.out.println(i+"========");
            if(i%2 == 0){
                int b = 1/0;
            }
            User user2 = new User();
            user2.setAge(17);
            user2.setName("daming");
            user2.setSex(0);
            userMapper.insert(user2);
        }catch (Exception e){
            e.printStackTrace();
            //手动回滚事务
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return "success";
    }
}
