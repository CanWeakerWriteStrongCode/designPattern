package com.xcx.designPattern.singleton.type7;


import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonTest07 {

    public static void main(String[] args) {
        System.out.println("使用静态内部类完成单例模式");
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2); // true
        System.out.println("instance.hashCode=" + instance.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode());

        Class<?> singletonClass = Singleton.class;
        try {
            Constructor<?>[] constructors = singletonClass.getDeclaredConstructors();
            constructors[0].setAccessible(true);
            Singleton instance3 = (Singleton) constructors[0].newInstance();
            if (instance3 == instance) {
                System.out.println("attack failed,攻击失败");
            } else {
                System.out.println("attack success!攻击成功，创建了多个实例");
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
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
            throw new RuntimeException("懒汉式单例模式不能创建多个实例");
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