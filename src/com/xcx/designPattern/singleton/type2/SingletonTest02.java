package com.xcx.designPattern.singleton.type2;

import java.io.Serializable;

public class SingletonTest02 {

    public static void main(String[] args) {
        //����
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2); // true
        System.out.println("instance.hashCode=" + instance.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode());
    }

}

//����ʽ(��̬����)

class Singleton implements Cloneable, Serializable {
    private static final long serialVersionUID = 1L;

    //1. ������˽�л�, �ⲿ��new
    private Singleton() {
        // �������乥��
        if (null != instance) {
            throw new RuntimeException("����ʽ����ģʽ�������ظ��������");
        }
    }


    //2.�����ڲ���������ʵ��
    private static final Singleton instance;

    static { // �ھ�̬������У�������������
        instance = new Singleton();
    }

    //3. �ṩһ�����еľ�̬����������ʵ������
    public static Singleton getInstance() {
        return instance;
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