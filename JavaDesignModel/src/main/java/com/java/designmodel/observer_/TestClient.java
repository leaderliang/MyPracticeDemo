package com.java.designmodel.observer_;

/**
 * TODO
 * <p>
 * Note:
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @since 2023/03/19 22:32
 */
class TestClient {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        LaoLiang laoLiang = new LaoLiang(station);
        LaoWang laoWang = new LaoWang(station);

        station.registerWeather(laoLiang);
        station.registerWeather(laoWang);

        station.setTemperature(-12);
        station.setTemperature(-15);
        station.setDampness(100);
    }
}
