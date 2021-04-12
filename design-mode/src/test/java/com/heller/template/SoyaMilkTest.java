package com.heller.template;

import org.junit.Test;

import static org.junit.Assert.*;

public class SoyaMilkTest {
    @Test
    public void test() {
        PeanutSoyaMilk peanutSoyaMilk = new PeanutSoyaMilk();
        peanutSoyaMilk.make();

        RedBeanSoyaMilk redBeanSoyaMilk = new RedBeanSoyaMilk();
        redBeanSoyaMilk.make();
    }
}