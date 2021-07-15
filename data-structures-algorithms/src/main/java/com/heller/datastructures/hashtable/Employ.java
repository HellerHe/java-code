package com.heller.datastructures.hashtable;

public class Employ {
    private int id;
    private String name;
    private Employ next;

    public Employ(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employ getNext() {
        return next;
    }

    public void setNext(Employ next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Employ{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
