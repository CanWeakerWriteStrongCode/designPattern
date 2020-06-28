package com.xcx.designPattern.singleton.casSingleton;

import java.util.concurrent.atomic.AtomicReference;

public class CASSingletonTest {
    public static void main(String[] args) {
        CASSingleton instance = CASSingleton.getInstance();
        CASSingleton instance2 = CASSingleton.getInstance();
        System.out.println(instance == instance2);

        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());
    }

}

class CASSingleton {
    private static AtomicReference<CASSingleton> INSTANCE = new AtomicReference<>();

    private CASSingleton() {
    }

    public static CASSingleton getInstance() {
        for (; ; ) {
            CASSingleton instance = INSTANCE.get();
            if (instance != null) {
                return instance;
            }
            instance = new CASSingleton();
            if (INSTANCE.compareAndSet(null, instance)) {
                return instance;
            }
        }
    }
}
