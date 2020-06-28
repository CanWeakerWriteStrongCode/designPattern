package com.xcx.designPattern.singleton.threadUnsafeLazyLoadSingleton;


public class ThreadUnsafeLazyLoadSingletonTest {

    public static void main(String[] args) {
        System.out.println("����ʽ1 �� �̲߳���ȫ~");
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

    //�ṩһ����̬�Ĺ��з�������ʹ�õ��÷���ʱ����ȥ���� instance
    //������ʽ
    public static ThreadUnsafeLazyLoadSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadUnsafeLazyLoadSingleton();
        }
        return instance;
    }
}