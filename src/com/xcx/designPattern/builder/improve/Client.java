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
        HighHouseBuilder highHouseBuilder = new HighHouseBuilder();
        //���ý�����
        houseDirector.setHouseBuilder(highHouseBuilder);
        //��ɸǷ��ӣ����ز�Ʒ(��¥)
        houseDirector.constructHouse();

        StringBuilder stringBuilder = new StringBuilder();

    }
}
