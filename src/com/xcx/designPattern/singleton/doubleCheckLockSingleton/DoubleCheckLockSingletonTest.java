package com.xcx.designPattern.singleton.doubleCheckLockSingleton;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DoubleCheckLockSingletonTest {

    public static void main(String[] args) {
        System.out.println("双重检查");
        DoubleCheckLockSingleton instance = DoubleCheckLockSingleton.getInstance();
        DoubleCheckLockSingleton instance2 = DoubleCheckLockSingleton.getInstance();
        System.out.println(instance == instance2); // true
        System.out.println("instance.hashCode=" + instance.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode());

    }

}

// 懒汉式(线程安全，同步方法)
class DoubleCheckLockSingleton {
    // volatile 1.5版本后才能禁止指令重排
    private static volatile DoubleCheckLockSingleton instance;

    private DoubleCheckLockSingleton() {
    }

    //提供一个静态的公有方法，加入双重检查代码，解决线程安全问题, 同时解决懒加载问题
    //同时保证了效率, 推荐使用

    public static DoubleCheckLockSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckLockSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckLockSingleton();
                }
            }

        }
        return instance;
    }
}

class DoubleCheckLockSingletonLock {
    private static DoubleCheckLockSingletonLock instance = null;
    private static Lock lock = new ReentrantLock();

    private DoubleCheckLockSingletonLock() {
    }

    public static DoubleCheckLockSingletonLock getInstance() {
        if (instance == null) {
            lock.lock(); // 显式调用，手动加锁
            if (instance == null) {
                instance = new DoubleCheckLockSingletonLock();
            }
            lock.unlock(); // 显式调用，手动解锁
        }
        return instance;
    }
}