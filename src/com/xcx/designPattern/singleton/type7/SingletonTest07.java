package com.xcx.designPattern.singleton.type7;


import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonTest07 {

    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException, CloneNotSupportedException {
        System.out.println("ʹ�þ�̬�ڲ�����ɵ���ģʽ");
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();


        // ���л�
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:\\single.obj"));
        oos.writeObject(instance);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("d:\\single.obj")));
        Singleton instance3 = (Singleton) ois.readObject();

        // ����
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

// ��̬�ڲ�����ɣ� �Ƽ�ʹ�ã�����ģʽ�޷���ֹ���乥��
class Singleton implements Cloneable, Serializable {

    private static final long serialVersionUID = 1L;

    private static boolean firstConstructFlag = true;

    //������˽�л�
    private Singleton() {
        // ������غ��䣬�����˷��乥�����ȷ��������޷�����
        checkFirstConstruct();
    }

    private void checkFirstConstruct() {
        if (firstConstructFlag) {
            firstConstructFlag = false;
        } else {
            throw new RuntimeException("����ʽ����ģʽ�����÷��䴴�����ʵ��");
        }
    }

    //дһ����̬�ڲ���,��������һ����̬���� Singleton
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    //�ṩһ����̬�Ĺ��з�����ֱ�ӷ���SingletonInstance.INSTANCE
    public static Singleton getInstance() {

        return SingletonHolder.INSTANCE;
    }

    /**
     * ��ֹ��¡����
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return getInstance();
    }

    /**
     * ��ֹ���л�����
     *
     * @return
     */
    private Object readResolve() {
        return getInstance();
    }

}