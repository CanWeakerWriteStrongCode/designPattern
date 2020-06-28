package com.xcx.designPattern.singleton.doubleCheckLockSingleton;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DoubleCheckLockSingletonTest {

    public static void main(String[] args) {
        System.out.println("˫�ؼ��");
        DoubleCheckLockSingleton instance = DoubleCheckLockSingleton.getInstance();
        DoubleCheckLockSingleton instance2 = DoubleCheckLockSingleton.getInstance();
        System.out.println(instance == instance2); // true
        System.out.println("instance.hashCode=" + instance.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode());

    }

}

// ����ʽ(�̰߳�ȫ��ͬ������)
class DoubleCheckLockSingleton {
    // volatile 1.5�汾����ܽ�ָֹ������
    private static volatile DoubleCheckLockSingleton instance;

    private DoubleCheckLockSingleton() {
    }

    //�ṩһ����̬�Ĺ��з���������˫�ؼ����룬����̰߳�ȫ����, ͬʱ�������������
    //ͬʱ��֤��Ч��, �Ƽ�ʹ��

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
            lock.lock(); // ��ʽ���ã��ֶ�����
            if (instance == null) {
                instance = new DoubleCheckLockSingletonLock();
            }
            lock.unlock(); // ��ʽ���ã��ֶ�����
        }
        return instance;
    }
}