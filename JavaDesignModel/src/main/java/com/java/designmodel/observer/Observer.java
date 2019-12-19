package com.java.designmodel.observer;

/**
 * TODO Observer (抽象观察者):为所有的具体观察者定义一个接口，在得到主题通知时更新自己。
 * 定义一个接到通知的更新方法，即收件人收到通知后的反应
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/03/24 16:29
 */
public interface Observer {

    void update(String msg);

}
