package com.java.test;

public class Test extends Male {

    public Test(String name) {
        super(name);
    }


    /**
     * 任何子类必须重写父类的抽象方法，或者声明自身为抽象类。
     *
     * @return double
     */
    @Override
    public double coding() {
        return 0;
    }


    public static void main(String[] args) {
        /* 以下是不允许的 抽象类不能被实例化*/
//        Male male = new Male("name");


    }


    @Override
    public void teach() {

    }

    @Override
    public void travel() {

    }

    @Override
    public void dance() {

    }

    @Override
    public void pregnancy() {

    }
}