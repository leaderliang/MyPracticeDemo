package com.java.practice.inner_class;

/**
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/12/29 11:22
 */
public class Client {

    public void run() {

        int a = 12;

        new OuterClass().new InterClass() {

            @Override
            void test() {
                int b = a + 1;
                System.out.println(b);
            }
        };


        new OuterClass.InterClass1() {

            @Override
            void test1() {

            }
        };


        new OuterClass.InterClass2() {

            @Override
            public void test2() {

            }
        };


    }
}
