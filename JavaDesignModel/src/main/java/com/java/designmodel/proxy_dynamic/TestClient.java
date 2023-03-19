package com.java.designmodel.proxy_dynamic;


import java.lang.reflect.Proxy;

/**
 * TODO 动态代理
 *
 * 遇到以下场景时使用代理模式
 * - 无法直接访问某个对象
 * - 不想直接访问某个对象
 * - 访问某个对象存在困难
 *
 * @author dev.liang  <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/03/28 00:14
 */
public class TestClient {


    public static void main(String[] args) {
        // 是否保存生成的代理类class文件，默认false不保存。修改此系统变量：
        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        // 会在当前工程创建个目录  com.sun.proxy.$Proxy0 or $Proxy1 等

        //创建多个委托类
        Subject mRealSubject = new RealSubject();
        // 委托类classLoader
        ClassLoader classLoader = mRealSubject.getClass().getClassLoader();
        // 委托类对应的 ProxyHandler
        DynamicProxyHandler mProxy = new DynamicProxyHandler(mRealSubject);
        Class[] classes = new Class[]{Subject.class};

        Class<?>[] interfaces = mRealSubject.getClass().getInterfaces();
        // 代理类
        Subject proxySubject = (Subject) Proxy.newProxyInstance(classLoader, classes, mProxy);
        // 另一种写法
        Subject proxySubject_ = (Subject) Proxy.newProxyInstance(classLoader, interfaces, mProxy);
        //由代理类去做具体的操作
        proxySubject.doSomething();
    }
}