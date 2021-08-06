package com.java.practice.classload;

/**
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2020/05/26 14:41
 */
class BaseCodeBlock {


    public BaseCodeBlock() {
        System.out.println("这里是父类的构造方法");
    }

    public BaseCodeBlock(String s) {
        System.out.println("这里是父类的构造方法" + s);
    }

    public void msg() {
        System.out.println("这里是父类的普通方法");
    }

    public static void msg2() {
        System.out.println("这里是父类的静态方法");
    }

    static {
        System.out.println("这里是父类的静态代码块");
    }


    Other2 o2 = new Other2();

    {
        System.out.println("这里是父类的普通代码块");
    }


}

