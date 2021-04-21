package com.heller.visitor;

//双分派
public class Man implements Person {
    @Override
    public void accept(Action action) {
        action.getManResult(this);
    }
}
