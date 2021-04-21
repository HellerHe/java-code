package com.heller.command;

public interface Command {
    public void execute();

    public void undo();
}
