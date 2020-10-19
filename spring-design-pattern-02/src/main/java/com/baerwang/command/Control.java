package com.baerwang.command;

/**
 * @author baerwang
 * @since 2020/10/19 14:56
 */
public class Control {

    /*private Command onCommand, offCommand, changeChannel;

    public Control(Command on, Command off, Command channel) {
        this.onCommand = on;
        this.offCommand = off;
        this.changeChannel = channel;
    }

    public void turnOn() {
        this.onCommand.execute();
    }

    public void turnOff() {
        this.offCommand.execute();
    }

    public void changeChannel() {
        this.changeChannel.execute();
    }*/


    private Command command;

    public Control(Command command) {
        this.command = command;
    }

    public void execute() {
        this.command.execute();
    }
}
