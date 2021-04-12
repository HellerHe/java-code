package com.heller.facade;

import org.junit.Test;

import static org.junit.Assert.*;

public class HomeTheaterFacadeTest {
    @Test
    public void test() {
        HomeTheaterFacade facade = new HomeTheaterFacade(TheaterLight.getInstance(),
                Popcorn.getInstance(), Projector.getInstance(), Screen.getInstance(),
                DVDPlayer.getInstance());
        facade.ready();
        facade.play();
        facade.pause();
        facade.end();
    }
}