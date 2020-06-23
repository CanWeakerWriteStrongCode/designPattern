package com.xcx.designPattern.singleton.type7;


import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonTest07 {

    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException, CloneNotSupportedException {
        System.out.println("使用静态内部类完成单例模式");
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();


        // 序列化
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:\\single.obj"));
        oos.writeObject(instance);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("d:\\single.obj")));
        Singleton instance3 = (Singleton) ois.readObject();

        // 反射
        Class<?> singletonClass = Singleton.class;
        Constructor<?>[] constructors = singletonClass.getDeclaredConstructors();
        constructors[0].setAccessible(true);
        Singleton instance4 = (Singleton) constructors[0].newInstance();

        Singleton instance5 = (Singleton) instance.clone();

        System.out.println(instance == instance2); // true
        System.out.println(instance == instance3); // true
        System.out.println(instance == instance4); // true
        System.out.println(instance == instance5); // true
        System.out.println("instance.hashCode=" + instance.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode());
        System.out.println("instance3.hashCode=" + instance3.hashCode());
        System.out.println("instance4.hashCode=" + instance4.hashCode());
        System.out.println("instance5.hashCode=" + instance5.hashCode());
    }

}

// 静态内部类完成， 推荐使用，懒汉模式无法防止反射攻击
class Singleton implements Cloneable, Serializable {

    private static final long serialVersionUID = 1L;

    private static boolean firstConstructFlag = true;

    //构造器私有化
    private Singleton() {
        // 如果加载后反射，防御了反射攻击。先反射后加载无法防御
        checkFirstConstruct();
    }

    private void checkFirstConstruct() {
        if (firstConstructFlag) {
            firstConstructFlag = false;
        } else {
            throw new RuntimeException("懒汉式单例模式不能用反射创建多个实例");
        }
    }

    //写一个静态内部类,该类中有一个静态属性 Singleton
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    //提供一个静态的公有方法，直接返回SingletonInstance.INSTANCE
    public static Singleton getInstance() {

        return SingletonHolder.INSTANCE;
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