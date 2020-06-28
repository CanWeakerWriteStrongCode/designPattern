package com.xcx.designPattern.singleton.UnsafeLazyLoadSingleton;


public class UnsafeLazyLoadSingletonTest {

    public static void main(String[] args) {
        System.out.println("����ʽ1 �� �̲߳���ȫ~");
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

    //�ṩһ����̬�Ĺ��з�������ʹ�õ��÷���ʱ����ȥ���� instance
    //������ʽ
    public static UnsafeLazyLoadSingleton getInstance() {
        if (instance == null) {
            instance = new UnsafeLazyLoadSingleton();
        }
        return instance;
    }
}