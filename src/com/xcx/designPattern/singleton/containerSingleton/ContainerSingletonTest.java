package com.xcx.designPattern.singleton.containerSingleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ContainerSingletonTest {
    public static void main(String[] args) {
        ContainerSingleton instance = (ContainerSingleton) ContainerSingleton.getBean("com.xcx.designPattern.singleton.type11.Singleton");
        ContainerSingleton instance2 = (ContainerSingleton) ContainerSingleton.getBean("com.xcx.designPattern.singleton.type11.Singleton");
        System.out.println(instance == instance2);

        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());
    }

}


class ContainerSingleton {

    private ContainerSingleton() {
    }

    private static Map<String, Object> ioc = new ConcurrentHashMap<String, Object>();

    public static Object getBean(String className) {

        if (!ioc.containsKey(className)) {
            synchronized (ioc) {
                if (!ioc.containsKey(className)) {
                    Object obj = null;
                    try {
                        obj = Class.forName(className).newInstance();
                        ioc.put(className, obj);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    // return obj; 为了这点速度没必要吧
                }
            }
        }
        return ioc.get(className);
    }
}
