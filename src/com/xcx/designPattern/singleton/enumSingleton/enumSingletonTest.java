package com.xcx.designPattern.singleton.enumSingleton;

public class enumSingletonTest {
    public static void main(String[] args) {
        enumSingleton instance = enumSingleton.INSTANCE;
        enumSingleton instance2 = enumSingleton.INSTANCE;
        System.out.println(instance == instance2);

        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());
        System.out.println(instance.name());
        instance.sayOK();
    }
}

//ʹ��ö�٣�����ʵ�ֵ���, �����Ƽ�
enum enumSingleton {
    INSTANCE;//ֻ��һ������

    public void sayOK() {
        System.out.println("ok~");
    }
}