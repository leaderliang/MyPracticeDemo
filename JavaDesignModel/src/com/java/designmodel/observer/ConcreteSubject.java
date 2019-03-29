package com.java.designmodel.observer;

import com.java.designmodel.utils.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * subscribe
 * TODO ConcreteSubject（具体主题）：
 *      又叫具体被观察者，将有关状态存入具体观察者对象；
 *      在具体主题内部状态改变时，给所有登记过的观察者发出通知.
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/03/24 16:34
 */
public class ConcreteSubject implements Subject{

    private List<Observer> observerList = new ArrayList();

    @Override
    public void attach(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notify(String msg) {
        /*循环通知收件人（观察者）*/
        if(!CollectionUtils.isEmpty(observerList)) {
            for (Observer observer : observerList) {
                observer.update(msg);
            }
        }
    }
}