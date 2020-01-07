package com.leaderliang.myapplication.test;


import android.support.v4.util.Pair;

/**
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/12/31 20:00
 */
public class AndroidPair {

    public static void main(String[] args) {

        String PAIR = "PAIR";

        Pair p1 = new Pair(18, "张三"); // 通过 构造函数 实例化对象
        Pair p2 = Pair.create(20, "李四");//通过 create方法 实例化对象
        Pair p3 = new Pair(18, "张三"); // 通过 构造函数 实例化对象


        /*boolean e1 = p1.equals(p2);
        System.out.println("RESULT: " + e1);// false
        // Pair的 equals 不是地址比较

        boolean e2 = p1.equals(p3);
        System.out.println("RESULT: " + e2); //true
        // Pair的 equals 是值比较，而不是地址比较，当且仅当元素值一致时返回true

        boolean e3 = p1.equals("18");
        System.out.println("RESULT: " + e3);// false

        boolean e4 = p1.equals(18);
        System.out.println("RESULT: " + e4);// false*/

        boolean e5 = p1 == p3;
        System.out.println("RESULT: " + e5);
    }

}
