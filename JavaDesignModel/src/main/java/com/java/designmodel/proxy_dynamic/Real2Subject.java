package com.java.designmodel.proxy_dynamic;

/**
 * TODO
 * 委托类
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/03/27 23:58
 */
public class Real2Subject implements Subject {
    @Override
    public void doSomething() {
        System.out.println("This is Real2Subject doSomeThing");
    }
}