package com.java.practice.inner_class;

/**
 * TODO
 * 非静态内部类会持有外部类引用
 *
 * interface 和 静态内部类一样，不会持有外部类引用
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/12/29 11:20
 */
public class OuterClass {

    public abstract class InterClass {
        abstract void test();
    }


    public static abstract class InterClass1 {
        abstract void test1();
    }

    public interface InterClass2 {
        void test2();
    }
}