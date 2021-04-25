package com.example.test.myaop.sourcecode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;
/*
* 总结一下：
* 动态代理的本质就是，生成一个继承自Proxy，实现被代理接口(IProvider)的类 - Proxy0。
* Proxy0 持有InvocationHandler实例，InvocationHandler 持有SimpleProvider实例。
* Proxy0调用接口 getData方法时，先传递给InvocationHandler，InvocationHandler再传递给SimpleProvider实例。
*
* */
//Proxy0 是动态生成的类，继承自Proxy，实现了IProvider接口
public final class $Proxy0 extends Proxy implements IProvider {
    private static Method m1;
    private static Method m2;
    private static Method m3;
    private static Method m0;

    public $Proxy0(InvocationHandler var1)   {
        super(var1);
    }

    public final boolean equals(Object var1)   {
        try {
            return ((Boolean)super.h.invoke(this, m1, new Object[]{var1})).booleanValue();
        } catch (RuntimeException | Error var3) {
            throw var3;
        } catch (Throwable var4) {
            throw new UndeclaredThrowableException(var4);
        }
    }

    public final String toString()  {
        try {
            return (String)super.h.invoke(this, m2, (Object[])null);
        } catch (RuntimeException | Error var2) {
            throw var2;
        } catch (Throwable var3) {
            throw new UndeclaredThrowableException(var3);
        }
    }

    public final String getData(String var1)  {
        try {
            //m3就是IProvider 接口的getData方法
            //super.h 是父类java.lang.reflect.Proxy的属性 InvocationHandler
            return (String)super.h.invoke(this, m3, new Object[]{var1});
        } catch (RuntimeException | Error var3) {
            throw var3;
        } catch (Throwable var4) {
            throw new UndeclaredThrowableException(var4);
        }
    }

    public final int hashCode()   {
        try {
            return ((Integer)super.h.invoke(this, m0, (Object[])null)).intValue();
        } catch (RuntimeException | Error var2) {
            throw var2;
        } catch (Throwable var3) {
            throw new UndeclaredThrowableException(var3);
        }
    }

    static {
        try {
            m1 = Class.forName("java.lang.Object").getMethod("equals", new Class[]{Class.forName("java.lang.Object")});
            m2 = Class.forName("java.lang.Object").getMethod("toString", new Class[0]);
            //m3就是IProvider 接口的getData方法
            m3 = Class.forName("aop.IProvider").getMethod("getData", new Class[]{Class.forName("java.lang.String")});
            m0 = Class.forName("java.lang.Object").getMethod("hashCode", new Class[0]);
        } catch (NoSuchMethodException var2) {
            throw new NoSuchMethodError(var2.getMessage());
        } catch (ClassNotFoundException var3) {
            throw new NoClassDefFoundError(var3.getMessage());
        }
    }
}
