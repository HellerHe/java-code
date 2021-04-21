package com.heller.visitor;

import java.util.LinkedList;
import java.util.List;

/**
 * ----访问者模式
 * 在被访问的类里面加一个对外提供接待访问者的接口 ，主要将数据结构与数据操作分离，解决数据结构和操作耦合性问题
 */
public class ObjectStructure {
    private List<Person> personList = new LinkedList<>();

    public void attach(Person person) {
        personList.add(person);
    }

    public void detach(Person person) {
        personList.remove(person);
    }

    public void display(Action action) {
        for (Person person : personList) {
            person.accept(action);
        }
    }
}
