package com.java.designmodel.proxy_dynamic;

/**
 * TODO 从代理模式的UML 类图中，我们可以得到如下结论：
 *
 * 代理对象和委托对象需要实现相同的接口（抽象类）
 * 代理对象持有委托对象的引用
 * 可以看到，代理模式非常简洁，总共就三个角色，包括抽象主题，委托者和代理者，下面用代码简单实现一下基础的代理模式。
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/03/27 23:55
 */
public interface Subject {
    void doSomething();
}