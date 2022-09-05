package com.java.practice.reflection;

import java.lang.reflect.Field;

/**
 * TODO 反射
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0.0
 * @since 2022/04/17 16:48
 */
public class ReflectionTest {
    // final 类型的基本数据类型，不支持反射修改
    private final int a = 2;
    private int b = 2;
    private final String c = "liang";

    public static void main(String[] args) {
        ReflectionTest reflectionTest = new ReflectionTest();
        System.out.println(reflectionTest.a);
        System.out.println(reflectionTest.b);
        System.out.println(reflectionTest.c);


        System.out.println();
        try {
//            ReflectionTest.class.getDeclaredField("a");
//            reflectionTest.getClass().getDeclaredField("a");
            Field field = Class.forName("com.java.practice.reflection.ReflectionTest").getDeclaredField("a");
            // 破解限制，final private 等限制
            field.setAccessible(true);
            field.setInt(reflectionTest, 3);
            System.out.println(reflectionTest.a);

            Field fieldb = ReflectionTest.class.getDeclaredField("b");
            fieldb.setAccessible(false);
            fieldb.setInt(reflectionTest, 3);
            System.out.println(reflectionTest.b);


            Field fieldc = reflectionTest.getClass().getDeclaredField("c");
            fieldc.setAccessible(true);
            fieldc.set(reflectionTest, "liang yan qiao");
            System.out.println(reflectionTest.c);




        } catch (ClassNotFoundException | NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
