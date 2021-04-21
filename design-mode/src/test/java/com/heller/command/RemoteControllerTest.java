package com.heller.command;

import org.junit.Test;

import static org.junit.Assert.*;

public class RemoteControllerTest {
    @Test
    public void test() {
        RemoteController remoteController = new RemoteController();
        LightReceiver lightReceiver = new LightReceiver();
        remoteController.setCommand(0, new LightOnCommand(lightReceiver), new LightOffCommand(lightReceiver));
        remoteController.onButton(0);
        remoteController.offButton(0);
        remoteController.undoButton();

        TVReceiver tvReceiver = new TVReceiver();
        remoteController.setCommand(1, new TVOnCommand(tvReceiver), new TVOffCommand(tvReceiver));
        remoteController.onButton(1);
        remoteController.offButton(1);
        remoteController.undoButton();
    }
}