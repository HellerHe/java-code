package com.heller.mediator;

import java.util.HashMap;
import java.util.Map;

/**
 * ----中介者模式
 * 中介对象来封装一系列的对象交互
 */
public class ConcreteMediator implements Mediator{
    private Map<String, Colleague> colleagueMap;
    private Map<String, String> interMap;

    public ConcreteMediator() {
        colleagueMap = new HashMap<String, Colleague>();
        interMap = new HashMap<String, String>();
    }

    @Override
    public void register(String name, Colleague colleague) {
        colleagueMap.put(name, colleague);
        if (colleague instanceof Alarm) {
            interMap.put("Alarm", name);
        } else if (colleague instanceof CoffeeMachine) {
            interMap.put("CoffeeMachine", name);
        } else if (colleague instanceof TV) {
            interMap.put("TV", name);
        } else if (colleague instanceof Curtains) {
            interMap.put("Curtains", name);
        }
    }

    @Override
    public void getMessage(int state, String name) {
        if (colleagueMap.get(name) instanceof Alarm) {
            if (state == 0) {
                CoffeeMachine coffeeMachine = (CoffeeMachine)colleagueMap.get(interMap.get("CoffeeMachine"));
                coffeeMachine.startCoffee();
                TV tv = (TV)colleagueMap.get(interMap.get("TV"));
                tv.startTv();
            } else if (state == 1) {
                TV tv = (TV)colleagueMap.get(interMap.get("TV"));
                tv.stopTv();
            }
        } else if (colleagueMap.get(name) instanceof CoffeeMachine) {
            Curtains curtains = (Curtains)colleagueMap.get(interMap.get("Curtains"));
            curtains.up();
        } else if (colleagueMap.get(name) instanceof TV) {

        } else if (colleagueMap.get(name) instanceof Curtains) {

        }
    }

    @Override
    public void sendMessage() {

    }
}
