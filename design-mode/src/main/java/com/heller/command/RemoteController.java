package com.heller.command;

/**
 * ----命令模式
 * 1. 将发起请求的对象与执行请求的对象解耦。
 * 2. 设计一个命令队列。只要把命令对象放到列队，就可以多线程的执行命令
 * 3. 实现对请求的撤销和重做
 * 4. 空命令也是一种设计模式，它为我们省去了判空的操作
 */
public class RemoteController {
    Command[] onCommands;
    Command[] offCommands;
    Command undoCommand;

    public RemoteController() {
        onCommands = new Command[5];
        offCommands = new Command[5];
        for (int i = 0; i < 5; i++) {
            onCommands[i] = new NoCommand();
            offCommands[i] = new NoCommand();
        }
    }

    public void setCommand(int n, Command onCommand, Command offCommand) {
        onCommands[n] = onCommand;
        offCommands[n] = offCommand;
    }

    public void onButton(int n) {
        onCommands[n].execute();
        undoCommand = onCommands[n];
    }

    public void offButton(int n) {
        offCommands[n].execute();
        undoCommand = offCommands[n];
    }

    public void undoButton() {
        undoCommand.undo();
    }
}
