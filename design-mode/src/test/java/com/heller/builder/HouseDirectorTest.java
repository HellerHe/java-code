package com.heller.builder;

import org.junit.Test;

import static org.junit.Assert.*;

public class HouseDirectorTest {

    @Test
    public void constructHouse() {
        HouseDirector houseDirector = new HouseDirector(new HighHouse());
        HouseDirector houseDirector1 = new HouseDirector(new CommonHouse());

        houseDirector.constructHouse();
        houseDirector1.constructHouse();
    }
}