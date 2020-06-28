package com.xcx.designPattern.singleton.type9;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReference;

public class SingletonTest09 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2);

        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());
    }

}

class Singleton {
    private static AtomicReference<Singleton> INSTANCE = new AtomicReference<>();

    private Singleton() {
    }

    public static Singleton getInstance() {
        for (; ; ) {
            Singleton instance = INSTANCE.get();
            if (instance != null) {
                return instance;
            }
            instance = new Singleton();
            if (INSTANCE.compareAndSet(null, instance)) {
                return instance;
            }
        }
    }
}
