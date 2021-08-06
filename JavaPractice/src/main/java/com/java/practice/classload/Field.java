package com.java.practice.classload;

/**
 * TODO
 *
 * 加载顺序：静态变量（静态代码块或静态函数）>普通属性 > 普通代码块 > 构造函数 > 普通函数
 * 静态变量、静态代码块、静态函数的加载顺序由它们所在的位置有关
 *
 *
 * 执行顺序：静态变量（静态代码块） > 普通属性 > 普通代码块 > 构造函数  
 *
 * 静态函数和普通函数只有被调用才会执行
 *
 * ————————————————
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2020/05/26 17:01
 */
public class Field {

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


    public void test() {
        System.out.println("a=" + a + "  b=" + b);
    }

}
