package com.java.designmodel.factory;

/**
 * TODO
 * 意图：定义一个创建对象的接口，让其子类自己决定实例化哪一个工厂类，工厂模式使其创建过程延迟到子类进行。
 * 主要解决：主要解决接口选择的问题。
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/03/23 14:14
 */
public class FactoryDemo {
    static ShapeFactory mShapeFactory;
    public static void main(String[] strings) {
        mShapeFactory = new ShapeFactory();
        mShapeFactory.getShape("CIRCLE").discribe();
        mShapeFactory.getShape("arc").discribe();
        mShapeFactory.getShape("Square").discribe();
        mShapeFactory.getShape("triangle").discribe();
    }
}