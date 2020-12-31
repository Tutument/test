package com.example.test.transactionalTest;

import com.example.test.transactionalTest.entity.User;
import com.example.test.transactionalTest.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionalController {

    @Autowired
    UserMapper userMapper;
    //测试一下controller事务是否有效
    @RequestMapping("/testTr")
    @Transactional(rollbackFor = Exception.class)
    public String test(){
        User user = new User();
        user.setAge(18);
        user.setName("linda");
        user.setSex(1);
        userMapper.insert(user);
        User user2 = new User();
        user2.setAge(17);
        user2.setName("daming");
        user2.setSex(0);
        userMapper.insert(user2);
        return "success";
    }
}
