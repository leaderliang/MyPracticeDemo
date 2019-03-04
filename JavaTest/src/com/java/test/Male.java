package com.java.test;

/**
 * 抽象类不能被实例化
 */
public abstract class Male implements People, teacher{

    public String name;

    public Male(String name) {
        this.name = name;
        System.out.println("name----"+name);
    }

    /**
     * 声明抽象方法会造成以下两个结果：
     * 如果一个类包含抽象方法，那么该类必须是抽象类。
     * 任何子类必须重写父类的抽象方法，或者声明自身为抽象类。
     * @return
     */
    public abstract double coding();

    @Override
    public void run() {

    }

    @Override
    public void sing() {

    }
}