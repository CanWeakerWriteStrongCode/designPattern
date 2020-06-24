package com.xcx.designPattern.builder.improve;

public class Client {
	public static void main(String[] args) {
		
		//����ͨ����
		CommonHouseBuilder commonHouseBuilder = new CommonHouseBuilder();
		//׼���������ӵ�ָ����
		HouseDirector houseDirector = new HouseDirector(commonHouseBuilder);
		
		//��ɸǷ��ӣ����ز�Ʒ(��ͨ����)
		House house = houseDirector.constructHouse();
		
		//System.out.println("�������");
		
		System.out.println("--------------------------");
		//�Ǹ�¥
		HighBuilding highBuilding = new HighBuilding();
		//���ý�����
		houseDirector.setHouseBuilder(highBuilding);
		//��ɸǷ��ӣ����ز�Ʒ(��¥)
		houseDirector.constructHouse();
		
		
		
	}
}
