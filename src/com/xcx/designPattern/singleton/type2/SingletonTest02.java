package com.xcx.designPattern.singleton.type2;

import java.io.Serializable;

public class SingletonTest02 {

    public static void main(String[] args) {
        //测试
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2); // true
        System.out.println("instance.hashCode=" + instance.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode());


        // 单例模式
        Runtime runtime = Runtime.getRuntime();
    }

}

//饿汉式(静态变量)

class Singleton implements Cloneable, Serializable {
    private static final long serialVersionUID = 1L;

    //1. 构造器私有化, 外部能new
    private Singleton() {
        // 防御反射攻击
        if (null != instance) {
            throw new RuntimeException("饿汉式单例模式不允许重复构造对象");
        }
    }


    //2.本类内部创建对象实例
    private static final Singleton instance;

    static { // 在静态代码块中，创建单例对象
        instance = new Singleton();
    }

    //3. 提供一个公有的静态方法，返回实例对象
    public static Singleton getInstance() {
        return instance;
    }

    /**
     * 防止克隆攻击
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return getInstance();
    }

    /**
     * 防止序列化攻击
     *
     * @return
     */
    private Object readResolve() {
        return getInstance();
    }


}