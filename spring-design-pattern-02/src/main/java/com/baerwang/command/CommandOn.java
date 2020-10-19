package com.baerwang.command;

/**
 * @author baerwang
 * @since 2020/10/19 14:53
 */
public class CommandOn implements Command {

    private Tv myTv;

    public CommandOn(Tv tv) {
        this.myTv = tv;
    }

    @Override
    public void execute() {
        myTv.turnOn();
    }
}
