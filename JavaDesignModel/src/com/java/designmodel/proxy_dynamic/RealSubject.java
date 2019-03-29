package com.java.designmodel.proxy_dynamic;

/**
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/03/27 23:58
 */
public class RealSubject implements Subject {
    @Override
    public void doSomething() {
        System.out.println("This is RealSubject doSomeThing");
    }
}