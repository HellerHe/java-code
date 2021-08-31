package com.heller.observer;

import org.junit.jupiter.api.Test;

public class WeatherDataTest {
    @Test
    public void test() {
        WeatherData weatherData = new WeatherData();
        Sina sina = new Sina();
        Baidu baidu = new Baidu();

        weatherData.registerObserver(sina);
        weatherData.registerObserver(baidu);
        weatherData.setData(10f, 100f, 3f);

        weatherData.removeObserver(sina);
        weatherData.setData(1f, 1f, 1f);
    }
}