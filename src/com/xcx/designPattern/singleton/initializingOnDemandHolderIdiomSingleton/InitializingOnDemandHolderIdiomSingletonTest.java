package com.xcx.designPattern.singleton.initializingOnDemandHolderIdiomSingleton;


import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InitializingOnDemandHolderIdiomSingletonTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException, CloneNotSupportedException {
        System.out.println("使用静态内部类完成单例模式");
        InitializingOnDemandHolderIdiomSingleton instance = InitializingOnDemandHolderIdiomSingleton.getInstance();
        InitializingOnDemandHolderIdiomSingleton instance2 = InitializingOnDemandHolderIdiomSingleton.getInstance();


        // 序列化
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:\\single.obj"));
        oos.writeObject(instance);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("d:\\single.obj")));
        InitializingOnDemandHolderIdiomSingleton instance3 = (InitializingOnDemandHolderIdiomSingleton) ois.readObject();

        // 反射
        Class<?> singletonClass = InitializingOnDemandHolderIdiomSingleton.class;
        Constructor<?>[] constructors = singletonClass.getDeclaredConstructors();
        constructors[0].setAccessible(true);
        InitializingOnDemandHolderIdiomSingleton instance4 = (InitializingOnDemandHolderIdiomSingleton) constructors[0].newInstance();

        InitializingOnDemandHolderIdiomSingleton instance5 = (InitializingOnDemandHolderIdiomSingleton) instance.clone();

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
class InitializingOnDemandHolderIdiomSingleton implements Cloneable, Serializable {

    private static final long serialVersionUID = 1L;

    private static boolean firstConstructFlag = true;

    //构造器私有化
    private InitializingOnDemandHolderIdiomSingleton() {
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
        private static InitializingOnDemandHolderIdiomSingleton INSTANCE = new InitializingOnDemandHolderIdiomSingleton();
    }

    //提供一个静态的公有方法，直接返回SingletonInstance.INSTANCE
    public static InitializingOnDemandHolderIdiomSingleton getInstance() {

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

