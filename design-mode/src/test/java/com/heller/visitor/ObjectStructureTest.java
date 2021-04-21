package com.heller.visitor;

import org.junit.Test;

import static org.junit.Assert.*;

public class ObjectStructureTest {
    @Test
    public void test() {
        ObjectStructure objectStructure = new ObjectStructure();
        objectStructure.attach(new Man());
        objectStructure.attach(new Woman());

        objectStructure.display(new Success());
        objectStructure.display(new Fail());
        objectStructure.display(new Wait());

    }
}