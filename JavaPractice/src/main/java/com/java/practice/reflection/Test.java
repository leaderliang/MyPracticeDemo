package com.java.practice.reflection;

import java.lang.reflect.Constructor;
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

    public static void main(String[] args) {

        try {
            declaredMethod();
            getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void declaredMethod() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

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


    public static void getObject() throws Exception {
        //1.获取字节码对象
        Class<?> clazz = Class.forName("com.java.practice.reflection.Student");

        //2.通过反射技术创建目标类的对象,注意抛出异常
        /*反射创建对象方案1：
            使用 目标类 的 无参构造 创建对象
        */
        Object o = clazz.newInstance();
        //这一步已经获取到了对象Student{name='null', age=0}
        System.out.println(o);

        /*反射创建对象方案2：
            使用 目标类 的 全参构造 创建对象
        * 思路：
        * 1.先获取指定的构造函数对象,注意需要指定构造函数的参数，传入的是.class字节码对象
        * 2.通过刚刚获取到的构造函数对象创建Student目标类的对象，并且给对象的属性赋值
        * */

        //3.获取目标类中指定的全参构造
        Constructor<?> c = clazz.getConstructor(String.class, int.class);
        //System.out.println(c);

        //4.通过获取到的构造函数：创建对象 + 给对象的属性赋值
        Object o2 = c.newInstance("赵六", 6);
        System.out.println(o2);
    }
}
