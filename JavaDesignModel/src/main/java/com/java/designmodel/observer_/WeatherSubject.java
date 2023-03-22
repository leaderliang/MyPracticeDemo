package com.java.designmodel.observer_;


/**
 * TODO  抽象主题角色
 * <p>
 * Note:
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @since 2023/03/20 13:52
 */
interface WeatherSubject {
    void registerWeather(Observer observer);

    void removeWeather(Observer observer);

    void notifyWeather();

}
