package com.xcx.designPattern.principle.inversion.improve;

public class DependencyPass {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ChangHong changHong = new ChangHong();

        // ��ʽ1�� ͨ���ӿڴ���ʵ������
        OpenAndClose1 openAndClose1 = new OpenAndClose1();
        openAndClose1.open(changHong);

        // ��ʽ2: ͨ�����췽����������
        OpenAndClose2 openAndClose2 = new OpenAndClose2(changHong);
        openAndClose2.open();

        // ��ʽ3 , ͨ��setter��������
        OpenAndClose3 openAndClose3 = new OpenAndClose3();
        openAndClose3.setTv(changHong);
        openAndClose3.open();

    }

}


interface ITV { //ITV�ӿ�
    public void play();
}


class ChangHong implements ITV {

    @Override
    public void play() {
        // TODO Auto-generated method stub
        System.out.println("������ӻ�����");
    }

}

// ��ʽ1�� ͨ���ӿڴ���ʵ������
// ���صĽӿ�
interface IOpenAndClose1 {
    public void open(ITV tv); //���󷽷�,���սӿ�
}

//// ʵ�ֽӿ�
class OpenAndClose1 implements IOpenAndClose1 {
    public void open(ITV tv) {
        tv.play();
    }
}

// ��ʽ2: ͨ�����췽����������
interface IOpenAndClose2 {
    public void open(); //���󷽷�
}

class OpenAndClose2 implements IOpenAndClose2 {
    public ITV tv; //��Ա

    public OpenAndClose2(ITV tv) { //������
        this.tv = tv;
    }

    public void open() {
        this.tv.play();
    }
}


// ��ʽ3 , ͨ��setter��������
interface IOpenAndClose3 {
    public void open(); // ���󷽷�

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
