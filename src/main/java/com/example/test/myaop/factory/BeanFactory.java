package com.example.test.myaop.factory;

import com.example.test.myaop.anotation.MyTransactional;
import com.example.test.myaop.util.ConnectionUtils;
import com.example.test.myaop.util.TransactionManager;

public class BeanFactory {

    public Object getBean(String name) throws Exception {
        Class<?> clazz = Class.forName(name);
        Object target = clazz.newInstance();
        MyTransactional annotation = clazz.getAnnotation(MyTransactional.class);
        if(annotation!=null){
            ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
            TransactionManager txManager = new TransactionManager();
            txManager.setConnectionUtils(new ConnectionUtils());
            proxyFactoryBean.setTarget(target);
            proxyFactoryBean.setTxManager(txManager);
            Object proxy = proxyFactoryBean.getProxy();
            return proxy;
        }
        return target;
    }
}
