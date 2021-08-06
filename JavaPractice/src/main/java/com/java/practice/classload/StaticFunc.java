package com.java.practice.classload;

/**
 * TODO
 *
 * 静态变量和静态代码块只会执行一次
 *
 * 静态函数在类被加载时就会被加载，但只有当其被调用时才会被执行
 *
 *
 *
 *
 *
 *  加载顺序：静态变量（静态代码块或静态函数）>普通属性 > 普通代码块 > 构造函数 > 普通函数
 *
 *  静态变量、静态代码块、静态函数的加载顺序由它们所在的位置有关
 *
 *  执行顺序：静态变量（静态代码块） > 普通属性 > 普通代码块 > 构造函数  
 *
 *  静态函数和普通函数只有被调用才会执行
 *
 *  ————————————————
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2020/05/27 11:53
 */
public class StaticFunc {
    public static String name = "zhang";


    public static void fun01() {
        name = "liang";
    }

    static {
        System.out.println(name);
    }

    public static void main(String[] args) {
        System.out.println(name);
        fun01();
        System.out.println(name);
    }
}
