package com.xcx.designPattern.factory.simplefactory.pizzastore.order;

import java.util.Calendar;

//�൱��һ���ͻ��ˣ���������
public class PizzaStore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new OrderPizza();
		
		//ʹ�ü򵥹���ģʽ
		//new OrderPizza(new SimpleFactory());
		//System.out.println("~~�˳�����~~");
		
		new OrderPizza2();

		// ����ģʽ
		Calendar instance = Calendar.getInstance();
	}

}
