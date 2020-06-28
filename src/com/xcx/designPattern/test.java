package com.xcx.designPattern;

public class test {

    private int b=10;

    public class a{

        public int b=9;

        public void testout(){

            System.out.println(this.b);
            System.out.println(test.this.b);
        }

    }

    public static void main(String[] args) {
        test test = new test();
        a c = test.new a();
        c.testout();
    }
}
