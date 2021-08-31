package com.heller.facade;

import org.junit.jupiter.api.Test;

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