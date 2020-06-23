package com.xcx.designPattern.factory.absfactory.pizzastore.order;

import java.util.Calendar;

public class PizzaStore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new OrderPizza(new BJFactory());
		new OrderPizza(new LDFactory());

		// 工厂模式
		Calendar instance = Calendar.getInstance();
	}

}
