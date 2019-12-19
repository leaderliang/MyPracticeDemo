package com.java.designmodel.proxy;

/**
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/03/27 23:59
 */
public class ProxySubject implements Subject {

    private final Subject mSubject;

    public ProxySubject(Subject subject) {
        mSubject = subject;
    }

    @Override
    public void doSomething() {
//        System.out.println("This is proxy doSomeThing");
        mSubject.doSomething();
    }
}