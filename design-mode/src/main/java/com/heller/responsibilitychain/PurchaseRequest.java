package com.heller.responsibilitychain;

public class PurchaseRequest {
    private int id;
    private int type;
    private float price;

    public PurchaseRequest(int id, int type, float price) {
        this.id = id;
        this.type = type;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public int getType() {
        return type;
    }

    public float getPrice() {
        return price;
    }
}
