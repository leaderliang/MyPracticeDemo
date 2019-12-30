package com.java.practice.reflect;

import java.lang.reflect.Field;

/**
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/12/27 21:51
 */
public class ReflectTest {

    public static void main(String[] args) {
        Person p = new Person();
        Class<?> c1 = p.getClass();
        Field[] f = c1.getFields();
        Field[] f1 = c1.getDeclaredFields();

        Class c2 = Person.class;
        Field[] ff = c2.getFields();

        try {
            Class c3 = Class.forName("com.java.practice.reflect.Person");
            c3.getDeclaredFields();
            c3.getFields();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
