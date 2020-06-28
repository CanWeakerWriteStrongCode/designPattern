package com.xcx.designPattern.singleton.threadSingleton;

public class ThreadSingletonTest {
    public static void main(String[] args) {
        ThreadSingleton instance = ThreadSingleton.getInstance();
        ThreadSingleton instance2 = ThreadSingleton.getInstance();
        System.out.println(instance == instance2);

        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());
    }

}

class ThreadSingleton {

    private static ThreadLocal<ThreadSingleton> threadLocalInstance = new ThreadLocal<ThreadSingleton>() {
        @Override
        protected ThreadSingleton initialValue() {
            return new ThreadSingleton();
        }
    };

    private ThreadSingleton() {
    }

    public static ThreadSingleton getInstance() {
        return threadLocalInstance.get();
    }

}
