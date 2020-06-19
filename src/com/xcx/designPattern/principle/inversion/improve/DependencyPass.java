package com.xcx.designPattern.principle.inversion.improve;

public class DependencyPass {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ChangHong changHong = new ChangHong();

        // 方式1： 通过接口传递实现依赖
        OpenAndClose1 openAndClose1 = new OpenAndClose1();
        openAndClose1.open(changHong);

        // 方式2: 通过构造方法依赖传递
        OpenAndClose2 openAndClose2 = new OpenAndClose2(changHong);
        openAndClose2.open();

        // 方式3 , 通过setter方法传递
        OpenAndClose3 openAndClose3 = new OpenAndClose3();
        openAndClose3.setTv(changHong);
        openAndClose3.open();

    }

}


interface ITV { //ITV接口
    public void play();
}


class ChangHong implements ITV {

    @Override
    public void play() {
        // TODO Auto-generated method stub
        System.out.println("长虹电视机，打开");
    }

}

// 方式1： 通过接口传递实现依赖
// 开关的接口
interface IOpenAndClose1 {
    public void open(ITV tv); //抽象方法,接收接口
}

//// 实现接口
class OpenAndClose1 implements IOpenAndClose1 {
    public void open(ITV tv) {
        tv.play();
    }
}

// 方式2: 通过构造方法依赖传递
interface IOpenAndClose2 {
    public void open(); //抽象方法
}

class OpenAndClose2 implements IOpenAndClose2 {
    public ITV tv; //成员

    public OpenAndClose2(ITV tv) { //构造器
        this.tv = tv;
    }

    public void open() {
        this.tv.play();
    }
}


// 方式3 , 通过setter方法传递
interface IOpenAndClose3 {
    public void open(); // 抽象方法

    public void setTv(ITV tv);
}


class OpenAndClose3 implements IOpenAndClose3 {
    private ITV tv;

    public void setTv(ITV tv) {
        this.tv = tv;
    }

    public void open() {
        this.tv.play();
    }
}
