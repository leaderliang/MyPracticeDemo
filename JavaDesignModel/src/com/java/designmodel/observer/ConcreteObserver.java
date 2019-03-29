package com.java.designmodel.observer;

/**
 * TODO （具体观察者）：实现抽象观察者定义的更新接口，当得到主题更改通知时更新自身的状态。
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/03/24 16:55
 */
public class ConcreteObserver implements Observer {

    String mObserverName;

    public ConcreteObserver(String mObserverName) {
        this.mObserverName = mObserverName;
    }

    @Override
    public void update(String msg) {
        System.out.println("具体观察者" + mObserverName + ",收到了信息:" + msg);
    }
}