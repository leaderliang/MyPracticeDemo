package com.java.designmodel.observer;

/**
 * TODO
 * Subject（抽象主题）：
 * 又叫抽象被观察者，把所有观察者对象的引用保存到一个集合里，
 * 每个主题都可以有任何数量的观察者。
 * 抽象主题提供一个接口，可以增加和删除观察者对象。
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/03/24 16:11
 */
public interface Subject {

    /**
     * 添加观察者
     *
     * @param observer
     */
    void attach(Observer observer);

    /**
     * 删除观察者
     *
     * @param observer
     */
    void detach(Observer observer);

    /**
     * 通知观察者
     *
     * @param msg
     */
    void notify(String msg);


}