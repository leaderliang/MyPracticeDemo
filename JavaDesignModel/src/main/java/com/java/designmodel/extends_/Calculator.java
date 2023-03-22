package com.java.designmodel.extends_;

/**
 * TODO
 * <p>
 * Note:
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @since 2023/03/22 11:49
 */
abstract class Calculator {

    public abstract void calculate();

    public int plus(int a, int b) {
        System.out.println(a + b);
        return a + b;
    }

    public int minus(int a, int b) {
        System.out.println(a - b);
        return a - b;
    }

}
