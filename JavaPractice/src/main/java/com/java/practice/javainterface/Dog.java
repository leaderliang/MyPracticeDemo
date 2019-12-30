package com.java.practice.javainterface;

/**
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/11/21 18:14
 */
//public class Dog implements Animal {
//    @Override
//    public void eat(String foodName) {
//        System.out.println(" food name " + foodName);
//    }
//
//
//}

public class Dog extends Animal {

    @Override
    void eat(String foodName) {
//        super.eat(foodName);
        System.out.println("dog eat " + foodName);
    }

    public void bark(){
        System.out.println("狗可以吠叫");
    }
}
