package com.example.test.myaop.service;

import com.example.test.myaop.anotation.MyTransactional;

@MyTransactional
public class UserServiceImpl implements UserService {
    @Override
    public void getUser() {

    }
}
