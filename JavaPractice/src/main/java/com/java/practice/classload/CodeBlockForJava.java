package com.java.practice.classload;

/**
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2020/05/26 14:41
 */
public class CodeBlockForJava extends BaseCodeBlock {

    private static String str = "456";


    {
        System.out.println("这里是子类的普通代码块 ");
    }

    public CodeBlockForJava() {
        System.out.println("这里是子类的构造方法" + " ");
    }

    public CodeBlockForJava(String s) {
        System.out.println("这里是子类的构造方法 "+s );
    }

    @Override
    public void msg() {
        System.out.println("这里是子类的普通方法");
    }

    public static void msg2() {
        System.out.println("这里是子类的静态方法");
    }

    static {
        System.out.println("这里是子类的静态代码块 ");
    }

    public static void main(String[] args) {
        BaseCodeBlock bcb = new CodeBlockForJava();
        bcb.msg();

    }

    Other o = new Other();


}
