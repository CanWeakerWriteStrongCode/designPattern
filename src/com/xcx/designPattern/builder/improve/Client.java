package com.xcx.designPattern.builder.improve;

public class Client {
    public static void main(String[] args) {

        //盖普通房子
        CommonHouseBuilder commonHouseBuilder = new CommonHouseBuilder();
        //准备创建房子的指挥者
        HouseDirector houseDirector = new HouseDirector(commonHouseBuilder);

        //完成盖房子，返回产品(普通房子)
        House house = houseDirector.constructHouse();

        //System.out.println("输出流程");

        System.out.println("--------------------------");
        //盖高楼
        HighHouseBuilder highHouseBuilder = new HighHouseBuilder();
        //重置建造者
        houseDirector.setHouseBuilder(highHouseBuilder);
        //完成盖房子，返回产品(高楼)
        houseDirector.constructHouse();

        StringBuilder stringBuilder = new StringBuilder();

    }
}
