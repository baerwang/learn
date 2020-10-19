package com.baerwang.command;

/**
 * @author baerwang
 * @since 2020/10/19 14:48
 */
public class Invoker {

    private Command command = null;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void runCommand() {
        this.command.execute();
    }
}
