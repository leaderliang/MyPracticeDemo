package com.java.designmodel.observer_;

/**
 * TODO  具体观察者角色
 * <p>
 * Note:
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @since 2023/03/20 14:00
 */
class LaoWang implements Observer {


    WeatherStation weatherStation;

    public LaoWang(WeatherStation weatherStation) {
        this.weatherStation = weatherStation;
    }

    @Override
    public void update() {
        if (weatherStation != null && weatherStation.getDampness() > 50) {
            System.out.println("需要开空调");
        }
    }


}
