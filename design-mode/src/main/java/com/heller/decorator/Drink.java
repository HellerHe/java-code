package com.heller.decorator;

public abstract class Drink {
    private String des;
    private Integer price;

    public abstract Integer cost();

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
