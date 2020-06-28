package com.xcx.designPattern.singleton.type10;

import java.util.concurrent.atomic.AtomicReference;

public class SingletonTest10 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2);

        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());
    }

}

class Singleton {

    private static ThreadLocal<Singleton> threadLocalInstance = new ThreadLocal<Singleton>() {
        @Override
        protected Singleton initialValue() {
            return new Singleton();
        }
    };

    private Singleton() {
    }

    public static Singleton getInstance() {
        return threadLocalInstance.get();
    }

}
