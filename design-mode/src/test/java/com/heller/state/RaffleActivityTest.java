package com.heller.state;

import org.junit.jupiter.api.Test;

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