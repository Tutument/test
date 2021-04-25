package com.example.test.myaop.sourcecode;

import java.lang.reflect.*;
import java.util.Objects;

import static java.lang.reflect.Proxy.getProxyClass0;

public class ProviderHandler implements InvocationHandler {
    Object target;

    public Object bind(Object target){
        this.target = target;
        //这里生成了代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //限流
        flowLimit(args);
        Object obj = method.invoke(target, args);
        //打印日志
        //logger.info("print log...");
        return obj;
    }

    private void flowLimit(Object[] args) {

    }

    //main
    public static void main(String[] args) {
        ProviderHandler providerHandler = new ProviderHandler();
        IProvider iProvider = (IProvider) providerHandler.bind(new SimpleProvider());
        iProvider.getData("weibo.data");
    }


    public static Object newProxyInstance(ClassLoader loader,
                                          Class<?>[] interfaces,
                                          InvocationHandler h)
            throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        //对 Invocationhandler做判空处理
        Objects.requireNonNull(h);
        //复制[IProvider接口]
        final Class<?>[] intfs = interfaces.clone();

        //根据IProvider的类加载器IProvider接口生成了Proxy类,关键：根据类加载器和接口对象在JVM缓存中生成一个类对象
        //Class<?> cl = getProxyClass0(loader, intfs);
        Class<?> cl =null;
        //获取构造器
        final Constructor<?> cons = cl.getConstructor(constructorParams);
        //保存InvocationHandler的引用
        final InvocationHandler ih = h;
        //通过构造器实例化Proxy代理对象
        return cons.newInstance(new Object[]{h});
    }

    private static final Class<?>[] constructorParams =
            { InvocationHandler.class };
}