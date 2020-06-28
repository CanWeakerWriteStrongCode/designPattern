package com.xcx.designPattern.singleton.threadUnsafeLazyLoadSingleton;


public class ThreadUnsafeLazyLoadSingletonTest {

    public static void main(String[] args) {
        System.out.println("懒汉式1 ， 线程不安全~");
        ThreadUnsafeLazyLoadSingleton instance = ThreadUnsafeLazyLoadSingleton.getInstance();
        ThreadUnsafeLazyLoadSingleton instance2 = ThreadUnsafeLazyLoadSingleton.getInstance();
        System.out.println(instance == instance2); // true
        System.out.println("instance.hashCode=" + instance.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode());
    }

}

class ThreadUnsafeLazyLoadSingleton {
    private static ThreadUnsafeLazyLoadSingleton instance;

    private ThreadUnsafeLazyLoadSingleton() {
    }

    //提供一个静态的公有方法，当使用到该方法时，才去创建 instance
    //即懒汉式
    public static ThreadUnsafeLazyLoadSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadUnsafeLazyLoadSingleton();
        }
        return instance;
    }
}