package com.java.practice.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * TODO
 * <p>
 * Note:
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @since 2022/08/26 16:59
 */
public class Test {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {


        Class<?> clazz1 = Class.forName("com.java.practice.reflection.Student");
        //反射调用成员方法
        Method m = clazz1.getDeclaredMethod("testInvoke", String.class);
        //使私有方法允许被调用
        m.setAccessible(true);
        Student student = new Student();
        //让指定实例来执行该方法
        m.invoke(student, "liangyanqiao");

        System.out.println("name=" + "name");
        System.out.println("不玩游戏，学Java！");

    }
}
