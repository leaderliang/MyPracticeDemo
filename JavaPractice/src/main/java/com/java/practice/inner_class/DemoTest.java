package com.java.practice.inner_class;

/**
 * TODO
 * 这样的话我就有点懵了，这样如何区分这个方法是接口的还是继承的，所以我们使用内部类解决这个问题
 *
 *
 * 内部类可以 解决继承及实现接口出现同名方法的问题！！！
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/12/29 13:26
 */
/*public class DemoTest extends MyDemo implements Demo{

    @Override
    public void test() {

    }
}*/


public class DemoTest extends MyDemo{

    private class Inner implements Demo{

        @Override
        public void test() {
            System.out.println("接口的 test 方法");
        }
    }


    public Demo getInner(){
        return new Inner();
    }


    public static void main(String[] args) {
        // 调用接口而来的 test() 方法
        DemoTest test = new DemoTest();
        Demo demo = test.getInner();
        demo.test();

        // 调用继承而来的 test() 方法
        test.test();

    }




}
