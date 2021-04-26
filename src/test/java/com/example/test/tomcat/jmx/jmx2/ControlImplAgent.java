package com.example.test.tomcat.jmx.jmx2;



import javax.management.*;

public class ControlImplAgent {

   /* public static void main(String[] args) throws MalformedObjectNameException, NullPointerException, InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException {

        // 创建MBeanServer
        MBeanServer server = MBeanServerFactory.createMBeanServer();

        // 为MBean创建ObjectName
        ObjectName controlImplName = new ObjectName("controlImpl:name=firstOne");

        // 注册MBean到Server中
        server.registerMBean(new ControlImpl(new ControlTarget(50, 200)), controlImplName);

        // 表现MBean(一种方式)
        ObjectName adapterName = new ObjectName("ControlImpl:name=htmladapter,port=8082");
        HtmlAdaptorServer adapter = new HtmlAdaptorServer();
        server.registerMBean(adapter, adapterName);

        adapter.start();
        //adapter.stop();
    }*/

}
