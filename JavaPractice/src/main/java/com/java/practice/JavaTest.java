package com.java.practice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/11/20 16:30
 */
public class JavaTest {
//    int monthDays[12] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    static int[] monthDays = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private static void getDays(int month) {
        System.out.println("getDays " + " --month" + --month + " month " + month);
//        return monthDays[--month];
    }

    public static void main(String[] args) {


//        getDays(2);
//        System.out.println("getDays " + getDays(1));

//        int i = 1;
//        i=i++;
//        i=i++;
//        i=i++;
//        i=i++;
//        i=i++;
//        System.out.println("i= "+i);


//        int i = 1, a = 0;
        // i++,++在后 先赋值 a = i，后运算 i = i+1
//        System.out.println("a=i++ --> " + (a=i++) + " a=i -->" + (a=i));
        // 打印： a=i++ --> 1； a=i --> 2

        // ++i,++在前，先运算 i = i + 1，后赋值 a = i
//        System.out.println("a=++i --> " + (a = ++i) + " a=i -->" + (a = i));
        // 打印： a=++i --> 2 ；a=i -->2


//        System.out.println("a=i-- --> " + (a = i--) + " a=i -->" + (a = i));
        // 打印：a=i-- --> 1; a=i --> 0

//        System.out.println("a=--i --> " + (a = --i) + " a=i -->" + (a = i));
        // 打印：a=--i --> 0; a=i --> 0


//        ExecutorService executorService = Executors.newSingleThreadExecutor();


        /*int a = 4;
        if(a > 0){
            testMethod();
            *//*System.out.println( "a>0");
            return;*//*
        }else if(a > 3){
            System.out.println("a > 3");
        }else if(a == 4){
            System.out.println("a==4");
        }else{
            System.out.println("else");
        }
        System.out.println("cccccc");*/

        LocalDate date = LocalDate.parse("2022-03-01", DateTimeFormatter.ofPattern("MM.dd"));
        System.out.println(date);

    }

    private static void testMethod() {
        System.out.println("a>0");
        return;
    }


    private static void testi() {
        int y = 0;
        int i = 0;
        y = ++y;
        y = ++y;
        y = ++y;
        y = ++y;
        y = ++y;
        System.out.println("y=" + y);
        i = i++;
        i = i++;
        i = i++;
        i = i++;
        i = i++;
        System.out.println("i=" + i);
//        Collections.synchronizedList();
    }

    /**
     *
     * Java中的%是取余的意思。
     * 取余运算符是%是一个双目运算符，它的操作数通常是正整数也可以是负数甚至是浮点数，如果负数参与此运算，则结果的正负取决于前面一个数是正数还是负数。
     * 对于整数，java的取余运算规则如下
     * a%b=a-(a/b)*b
     * 5%3=5-(5/3)*3=2
     * 5%-3=5-(5/-3)*-3=2
     * -5%3=-5-(-5/3)*3=-2
     * -5%-3=-5-(-5/-3)*-3=-2
     *
     * 如果操作数中有浮点数则采用的规则为 a%b=a-(b*q)，这里q=int(a/b)
     * 5.2%3.1=5.2-1*3.1=2.1
     * 5.2%-3.1=5.2-(-1)*(-3.1)=2.1
     * -5.2%3.1=-5.1-(-1)*3.1=-2.1
     * -5.2%-3.1=-5.1-(-1)*(-3.1)=-2.1
     * 扩展知识：
     *
     * java基础知识中运算符关于 %：任何整数模2不是0就是1 如何理解？
     * 一个任意数，除以10，余数为0~9。
     * 一个任意数，除以N，余数为0~N-1。
     * 一个任意数，除以2，余数为0~1。
     * 而 M % N 的意思就是M除以N余数是多少？
     * 所以 M % 2 的结果必然是0或1。
     */
    private void remaining(){
        System.out.println(0 % 4);
        System.out.println(1 % 4);
        System.out.println(2 % 4);
        System.out.println(3 % 4);
        System.out.println(4 % 4);
        System.out.println(5 % 4);
        System.out.println(6 % 4);
        System.out.println(7 % 4);
        System.out.println(8 % 4);
        System.out.println(9 % 4);
        System.out.println(10 % 4);
        System.out.println(11 % 4);
    }


}
