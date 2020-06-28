package com.xcx.designPattern.singleton.UnsafeLazyLoadSingleton;


public class UnsafeLazyLoadSingletonTest {

    public static void main(String[] args) {
        System.out.println("懒汉式1 ， 线程不安全~");
        UnsafeLazyLoadSingleton instance = UnsafeLazyLoadSingleton.getInstance();
        UnsafeLazyLoadSingleton instance2 = UnsafeLazyLoadSingleton.getInstance();
        System.out.println(instance == instance2); // true
        System.out.println("instance.hashCode=" + instance.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode());
    }

}

class UnsafeLazyLoadSingleton {
    private static UnsafeLazyLoadSingleton instance;

    private UnsafeLazyLoadSingleton() {
    }

    //提供一个静态的公有方法，当使用到该方法时，才去创建 instance
    //即懒汉式
    public static UnsafeLazyLoadSingleton getInstance() {
        if (instance == null) {
            instance = new UnsafeLazyLoadSingleton();
        }
        return instance;
    }
}