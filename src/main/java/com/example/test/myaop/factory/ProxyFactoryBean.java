package com.example.test.myaop.factory;

import com.example.test.myaop.util.TransactionManager;

import java.lang.reflect.Proxy;

public class ProxyFactoryBean {
    //通知
    private TransactionManager txManager;
    //目标对象
    private Object target;

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Object getProxy(){
        Object proxy = Proxy.newProxyInstance(this.getClass().getClassLoader(), this.getClass().getInterfaces(), (object, method, args) -> {
            try {
                txManager.beginTransaction();
                Object invoke = method.invoke(target,args);
                txManager.commit();
                return invoke;
            }catch (Exception e){
                txManager.rollback();
                throw new RuntimeException();
            }finally {
                txManager.release();
            }
        });
        return proxy;
    }
}
