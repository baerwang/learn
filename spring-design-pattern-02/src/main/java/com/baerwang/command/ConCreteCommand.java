package com.baerwang.command;

/**
 * @author baerwang
 * @since 2020/10/19 14:46
 */
public class ConCreteCommand implements Command {

    private Receiver receiver = null;

    private String state;

    public ConCreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        this.receiver.action();
    }
}
