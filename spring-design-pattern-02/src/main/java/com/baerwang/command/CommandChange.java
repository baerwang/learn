package com.baerwang.command;

/**
 * @author baerwang
 * @since 2020/10/19 14:54
 */
public class CommandChange implements Command {

    private Tv myTv;

    private int channel;

    public CommandChange(Tv tv, int channel) {
        this.myTv = tv;
        this.channel = channel;
    }

    @Override
    public void execute() {
        this.myTv.changeChannel(channel);
    }
}
