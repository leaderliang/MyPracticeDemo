package com.java.practice.addself;

/**
 * TODO
 * <p>
 * Note:
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @since 2022/11/07 12:42
 */
public class Test {
    public static void main(String[] args) {

        test();
    }

    public static void addOther() {
        int i = 1;
        i = i++;
        System.out.println("i= " + i);
        int j = i++;
        int k = i + ++i * i++;
        System.out.println("i= " + i);
        System.out.println("j= " + j);
        System.out.println("k= " + k);
    }

    /**
     * 在有多步运算的情况下，i++ 会先做其他运算，再自增；
     * ++i 会先做自增，再做其他运算；
     */
    public static void test() {
        int a = 1;// a= 1
        int b = a++; // b = 1
        System.out.println(a++);// 2
        System.out.println(++b);// 2
        System.out.println("a= " + a);// 3
        System.out.println("b= " + b);// 2

    }

    public static void testA() {
        int a = 10;
        //++
        for (int i = 0; i < 3; i++) {
            System.out.println("before" + a);
            System.out.println(++a);
            System.out.println("after" + a);
            System.out.println();
        }
        int b = 10;
        for (int i = 0; i < 3; i++) {
            System.out.println("before" + b);
            System.out.println(b++);
            System.out.println("after" + b);
            System.out.println();
        }

        // --
        int c = 10;
        for (int i = 0; i < 3; i++) {
            System.out.println("before" + c);
            System.out.println(--c);
            System.out.println("after" + c);
            System.out.println();
        }

        int d = 10;
        for (int i = 0; i < 3; i++) {
            System.out.println("before" + d);
            System.out.println(d--);
            System.out.println("after" + d);
            System.out.println();
        }
    }
}
