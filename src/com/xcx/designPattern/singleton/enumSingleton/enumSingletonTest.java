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

//使用枚举，可以实现单例, 最终推荐
enum enumSingleton {
    INSTANCE;//只有一个属性

    public void sayOK() {
        System.out.println("ok~");
    }
}