package com.xcx.designPattern.singleton.eagerSingleton;

public class EagerSingletonTest {

    public static void main(String[] args) {
        //测试
        EagerSingleton instance = EagerSingleton.getInstance();
        EagerSingleton instance2 = EagerSingleton.getInstance();
        System.out.println(instance == instance2); // true
        System.out.println("instance.hashCode=" + instance.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode());
    }

}

//饿汉式(静态变量)

class EagerSingleton {

    //1. 构造器私有化, 外部能new
    private EagerSingleton() {

    }

    //2.本类内部创建对象实例
    private static EagerSingleton instance = new EagerSingleton();

    //3. 提供一个公有的静态方法，返回实例对象
    public static EagerSingleton getInstance() {
        return instance;
    }

}