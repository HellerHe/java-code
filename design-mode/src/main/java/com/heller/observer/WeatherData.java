package com.heller.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * ----观察者模式
 * 以集合的方式来管理用户(Observer update())，包括注册，移除和通知。
 */
public class WeatherData implements Subject{
    private float temperature;
    private float pressure;
    private float humidity;
    private List<Observer> observers;

    public WeatherData() {
        observers = new ArrayList<Observer>();
    }

    public void setData(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        if (observers.contains(observer)) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature, pressure, humidity);
        }
    }
}
