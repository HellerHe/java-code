package com.heller.facade;

/**
 * ----外观模式/过程模式
 * 1.外观模式对外屏蔽了子系统的细节
 * 2.外观类(Facade): 为调用端提供统一的调用接口, 外观类知道哪些子系统负责处理请求,从而将调用端的请求代理给适当子系统对象
 * 3.子系统的集合：指模块或者子系统，处理 Facade 对象指派的任务
 */
public class HomeTheaterFacade {
    private TheaterLight theaterLight;
    private Popcorn popcorn;
    private Projector projector;
    private Screen screen;
    private DVDPlayer dVDPlayer;

    public HomeTheaterFacade(TheaterLight theaterLight, Popcorn popcorn, Projector projector, Screen screen, DVDPlayer dVDPlayer) {
        this.theaterLight = theaterLight;
        this.popcorn = popcorn;
        this.projector = projector;
        this.screen = screen;
        this.dVDPlayer = dVDPlayer;
    }

    public void ready() {
        popcorn.on();
        popcorn.pop();
        screen.down();
        projector.on();
        dVDPlayer.on();
        theaterLight.on();
    }

    public void play() {
        dVDPlayer.play();
    }

    public void pause() {
        dVDPlayer.pause();
    }

    public void end() {
        popcorn.off();
        theaterLight.bright();
        screen.up();
        projector.off();
        dVDPlayer.off();
    }
}
