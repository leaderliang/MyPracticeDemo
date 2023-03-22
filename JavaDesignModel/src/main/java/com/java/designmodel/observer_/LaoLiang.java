package com.java.designmodel.observer_;

/**
 * TODO  具体观察者角色
 * <p>
 * Note:
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @since 2023/03/20 14:00
 */
class LaoLiang implements Observer {


    WeatherStation weatherStation;

    public LaoLiang(WeatherStation weatherStation) {
        this.weatherStation = weatherStation;
    }

    @Override
    public void update() {
        if (weatherStation != null && weatherStation.getTemperature() < 0) {
            System.out.println(weatherStation.getTemperature());
            System.out.println("太冷了，需要穿羽绒服了！");
        }
    }


}
