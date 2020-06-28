package com.xcx.designPattern.singleton.type11;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SingletonTest11 {
    public static void main(String[] args) {
        ContainerSingleton instance = (ContainerSingleton) ContainerSingleton.getBean("com.xcx.designPattern.singleton.type11.ContainerSingleton");
        ContainerSingleton instance2 = (ContainerSingleton) ContainerSingleton.getBean("com.xcx.designPattern.singleton.type11.ContainerSingleton");
        System.out.println(instance == instance2);

        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());
    }

}


class ContainerSingleton {

    private ContainerSingleton () {}

    private static Map<String, Object> ioc = new ConcurrentHashMap<String, Object>();

    public static Object getBean(String className) {
        synchronized (ioc) {
            if (!ioc.containsKey(className)) {
                Object obj = null;
                try {
                    obj = Class.forName(className).newInstance();
                    ioc.put(className, obj);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return obj;
            } else {
                return ioc.get(className);
            }
        }
    }
}
