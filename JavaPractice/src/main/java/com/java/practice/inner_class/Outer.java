package com.java.practice.inner_class;

/**
 * TODO
 * <p>
 * 请在三个println 后括号中填空使得输出 25,20,18
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/12/25 20:12
 */
class Outer {
    public int age = 18;

    class Inner {
        public int age = 20;

        public void showAge() {
            int age = 25;
            System.out.println(age);//空1
            System.out.println(this.age);//空2
            System.out.println(Outer.this.age);//空3
        }

    }

    public void test(){
        new Inner().showAge();
    }


}
