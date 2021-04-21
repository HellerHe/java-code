package com.heller.iterator;

import java.util.Iterator;

public interface College {
    public String getName();

    public Department[] addDepartment(String name, String des);

    public Iterator createIterator();
}
