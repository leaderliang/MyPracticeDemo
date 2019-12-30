package com.java.practice.javainterface;

/**
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/11/21 18:24
 */
public class Test {

    public  void main(String[] args) {


        Dog dog = new Dog();
        dog.eat("bone");

        Animal animal = new Animal();
        animal.eat("animal");

        /*尽管 animal1 属于 Animal 类型，但是它运行的是 Dog 类的 eat 方法。
        这是由于在编译阶段，只是检查参数的引用类型。
        然而在运行时，Java 虚拟机(JVM)指定对象的类型并且运行该对象的方法。
        因此在上面的例子中，之所以能编译成功，是因为 Animal 类中存在 eat 方法，然而运行时，运行的是特定对象的方法。*/
        Animal animal1 = new Dog();
        animal1.eat("animal1");

    }

}
