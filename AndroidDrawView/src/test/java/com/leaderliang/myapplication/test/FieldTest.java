package com.leaderliang.myapplication.test;

import org.junit.Before;
import org.junit.Test;

/**
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2020/05/26 18:38
 */
public class FieldTest {


    // 静态代码块和静态属性谁在前谁先被加载
    public static String name= "zhangsan";

    static{
        System.out.println(name);
    }

    static{
        //程序会报错
//        System.out.println(name2);
    }
    public static String name2= "lisi";




    // 程序开始前会先初始化a=0，b=0，然后程序按顺序执行
    {
        a = 1;
    }

    int a = 2;

    int b = 1;

    {
        b = 3;
    }

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test() {
        System.out.println("a=" + a + "  b=" + b);
    }
}