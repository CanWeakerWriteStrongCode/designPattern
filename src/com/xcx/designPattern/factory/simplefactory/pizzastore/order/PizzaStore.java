package com.xcx.designPattern.factory.simplefactory.pizzastore.order;

import java.util.Calendar;

//相当于一个客户端，发出订购
public class PizzaStore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new OrderPizza();
		
		//使用简单工厂模式
		//new OrderPizza(new SimpleFactory());
		//System.out.println("~~退出程序~~");
		
		new OrderPizza2();

		// 工厂模式
		Calendar instance = Calendar.getInstance();
	}

}
