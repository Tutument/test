package com.example.test.jvm;


public class ClassLoadTest {

    public static void main(String[] args) {
        //

    }

    /**
     * 线程上下文类加载器
     * 破坏双亲委派机制
     */
    public void test01() {

        Thread.currentThread().getContextClassLoader();
        Thread.currentThread().setContextClassLoader(new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return super.loadClass(name);
            }
        });
    }

    public void test02() {
        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                synchronized (getClassLoadingLock(name)) {
                    // First, check if the class has already been loaded
                    Class<?> c = findLoadedClass(name);
                    if (c == null) {
                        long t0 = System.nanoTime();

                        //自己实现类加载器，来破坏双亲委派机制
                        /*try {
                            if (parent != null) {
                                c = parent.loadClass(name, false);
                            } else {
                                c = findBootstrapClassOrNull(name);

                        } catch (ClassNotFoundException e) {
                            // ClassNotFoundException thrown if class not found
                            // from the non-null parent class loader
                        }*/

                        if (c == null) {
                            // If still not found, then invoke findClass in order
                            // to find the class.
                            long t1 = System.nanoTime();
                            c = findClass(name);

                            // this is the defining class loader; record the stats
                            sun.misc.PerfCounter.getParentDelegationTime().addTime(t1 - t0);
                            sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
                            sun.misc.PerfCounter.getFindClasses().increment();
                        }
                    }
                   /* if (resolve) {
                        resolveClass(c);
                    }*/
                    return c;
                }
            }
        };


    }
    /**
     * 双亲委派实现
     */
    /* protected synchronized Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
       // 首先，检查请求的类是否已经被加载过了
        Class c = findLoadedClass(name);
        if (c == null) {
            try {
                if (parent != null) {
                    c = parent.loadClass(name, false);
                } else {
                    c = findBootstrapClassOrNull(name);
                }
            } catch (ClassNotFoundException e) {
                // 如果父类加载器抛出ClassNotFoundException
                // 说明父类加载器无法完成加载请求
            }
            if (c == null) {
                // 在父类加载器无法加载时
                // 再调用本身的findClass方法来进行类加载
                c = findClass(name);
            }
        }
        if (resolve) {
            resolveClass(c);
        }
        return c;
    }*/

}
