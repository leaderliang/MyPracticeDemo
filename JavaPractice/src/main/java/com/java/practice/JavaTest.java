package com.java.practice;

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


        int i = 1, a = 0;
        // 先赋值 a = i，后运算 i = i+1
//        System.out.println("a=i++ --> " + (a=i++) + " a=i -->" + (a=i));
        // 打印： a=i++ --> 1； a=i --> 2

        // 先运算 i = i + 1，后赋值 a = i
//        System.out.println("a=++i --> " + (a=++i) + " a=i -->" + (a=i));
        // 打印： a=++i --> 2 ；a=i -->2


//        System.out.println("a=i-- --> " + (a=i--) + " a=i -->" + (a=i));
        // 打印：a=i-- --> 1; a=i --> 0

//        System.out.println("a=--i --> " + (a=--i) + " a=i -->" + (a=i));
        // 打印：a=--i --> 0; a=i --> 0


//        ExecutorService executorService = Executors.newSingleThreadExecutor();



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
    }
}
