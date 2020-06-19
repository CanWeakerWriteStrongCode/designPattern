package com.xcx.designPattern.singleton.type7;


import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonTest07 {

    public static void main(String[] args) {
        System.out.println("ʹ�þ�̬�ڲ�����ɵ���ģʽ");
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
                System.out.println("attack failed,����ʧ��");
            } else {
                System.out.println("attack success!�����ɹ��������˶��ʵ��");
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
            throw new RuntimeException("����ʽ����ģʽ���ܴ������ʵ��");
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