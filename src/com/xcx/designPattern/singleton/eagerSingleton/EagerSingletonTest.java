package com.xcx.designPattern.singleton.eagerSingleton;

public class EagerSingletonTest {

    public static void main(String[] args) {
        //����
        EagerSingleton instance = EagerSingleton.getInstance();
        EagerSingleton instance2 = EagerSingleton.getInstance();
        System.out.println(instance == instance2); // true
        System.out.println("instance.hashCode=" + instance.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode());
    }

}

//����ʽ(��̬����)

class EagerSingleton {

    //1. ������˽�л�, �ⲿ��new
    private EagerSingleton() {

    }

    //2.�����ڲ���������ʵ��
    private static EagerSingleton instance = new EagerSingleton();

    //3. �ṩһ�����еľ�̬����������ʵ������
    public static EagerSingleton getInstance() {
        return instance;
    }

}