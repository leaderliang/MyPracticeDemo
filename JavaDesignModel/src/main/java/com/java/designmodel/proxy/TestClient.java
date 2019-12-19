package com.java.designmodel.proxy;

/**
 * TODO
 * 遇到以下场景时使用代理模式
 * - 无法直接访问某个对象
 * - 不想直接访问某个对象
 * - 访问某个对象存在困难
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/03/28 00:14
 */
public class TestClient {


    public static void main(String[] args) {
        //创建多个委托类
        Subject mRealSubject = new RealSubject();
//        mRealSubject = new Real2Subject();

        //创建代理类
        ProxySubject mProxy = new ProxySubject(mRealSubject);
        //由代理类去做具体的操作
        mProxy.doSomething();
    }
}