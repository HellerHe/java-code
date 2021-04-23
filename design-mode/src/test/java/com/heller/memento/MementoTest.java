package com.heller.memento;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MementoTest {
    @Test
    public void test() {
        ArrayList<Memento> mementos = new ArrayList<>();
        GameRole role = new GameRole(100, 100);
        System.out.println(role.getVit() + "--" + role.getDef());
        mementos.add(role.createMem());
        role.setDef(1);
        role.setVit(1);
        System.out.println(role.getVit() + "--" + role.getDef());
        role.recover(mementos.get(0));
        System.out.println(role.getVit() + "--" + role.getDef());
    }

}