package com.example.liangyanqiao.myapplication;

/**
 * TODO
 * Created by liang on 2018/3/20.
 */
public class JavaTest {

    static int age = 1;

    int age1 = 2;

    static {
        System.out.println("这是静态代码块");
    }

    {
        System.out.println("这是普通代码块 " + age1);
    }

    public JavaTest() {
        System.out.println("这是构造方法");
    }

    public static void show() {
        System.out.println("这是静态方法");
    }

    public void fun() {
        System.out.println("这是普通方法");
    }

    public static void main(String[] s) {
        //System.out.println(age);
        JavaTest t = new JavaTest();
        JavaTest.show();
//        t.fun();
        /*System.out.println(t.age1);*/

//        SingletonTest.getInstance();
    }


}
