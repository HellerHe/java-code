package com.heller.observer;

public class Sina implements Observer{
    private float temperature;
    private float pressure;
    private float humidity;

    @Override
    public void update(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }

    public void display() {
        System.out.println("***sina mTemperature: " + temperature + "***");
        System.out.println("***sina mPressure: " + pressure + "***");
        System.out.println("***sina mHumidity: " + humidity + "***");
    }
}
