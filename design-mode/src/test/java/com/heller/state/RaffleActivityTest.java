package com.heller.state;

import org.junit.Test;

import static org.junit.Assert.*;

public class RaffleActivityTest {
    @Test
    public void test(){
        RaffleActivity activity = new RaffleActivity(1);
        for (int i = 0; i < 20; i++) {
            activity.deductMoney();
            activity.raffle();
        }
    }
}