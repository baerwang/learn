package com.baerwang.command;

/**
 * @author baerwang
 * @since 2020/10/19 14:54
 */
public class CommandOff implements Command {

    private Tv myTv;

    public CommandOff(Tv tv) {
        this.myTv = tv;
    }

    @Override
    public void execute() {
        myTv.turnOff();
    }
}
