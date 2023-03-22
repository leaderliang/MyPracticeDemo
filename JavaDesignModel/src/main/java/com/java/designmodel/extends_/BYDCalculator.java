package com.java.designmodel.extends_;

/**
 * TODO
 * <p>
 * Note:
 * 原则：
 * - 保证基类所拥有的性质在子类中仍然成立；
 * - 子类拓展父类功能，但是不能改变父类原有的功能
 *
 * 里氏替换原则：
 * 子类必须完全实现父类的抽象方法，但是不能覆盖父类的非抽象方法；；
 * 子类可以实现自己特有的方法；
 * 当子类的方法实现父类的抽象方法时，方法的后置条件要比父类更加严格；
 * 子类的实例可以替代任何父类的实例，反之不成立。
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @since 2023/03/22 11:52
 */
class BYDCalculator extends Calculator{

    @Override
    public void calculate() {

    }

    @Override
    public int plus(int a, int b) {
        // 子类拓展父类功能，但是不能改变父类原有的功能
//        System.out.println(a * b);
//        return a * b;
        return super.plus(a, b);
    }
}
