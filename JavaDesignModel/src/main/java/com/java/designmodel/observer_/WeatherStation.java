package com.java.designmodel.observer_;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO  具体主题角色
 * <p>
 * Note:
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @since 2023/03/20 13:56
 */
class WeatherStation implements WeatherSubject {

    private int temperature = 0;
    /**
     * 湿度
     */
    private int dampness = 0;

    List<Observer> mObserverList = new ArrayList<>();

    @Override
    public void registerWeather(Observer observer) {
        mObserverList.add(observer);
    }

    @Override
    public void removeWeather(Observer observer) {
        mObserverList.remove(observer);
    }

    @Override
    public void notifyWeather() {
        for (Observer observer : mObserverList) {
            observer.update();
        }
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyWeather();
    }

    public int getDampness() {
        return dampness;
    }

    public void setDampness(int dampness) {
        this.dampness = dampness;
        notifyWeather();
    }
}
