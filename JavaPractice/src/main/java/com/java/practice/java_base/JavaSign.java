package com.java.practice.java_base;

/**
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2020/05/26 15:14
 */
public class JavaSign {


    public static void main(String[] args) {
        //        符号在前的就是先运算，后赋值；
        //        符号在后先赋值，后运算；
        int a = 0;
        System.out.println(++a);
        System.out.println(a);

        int b = 0;
        System.out.println(--b);
        System.out.println(b);

        int i = 0;
        System.out.println(i++);
        System.out.println(i);
        int j = 55;
        System.out.println(j--);
        System.out.println(j);
    }

}
