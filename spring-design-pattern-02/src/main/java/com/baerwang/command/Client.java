package com.baerwang.command;

/**
 * @author baerwang
 * @since 2020/10/19 14:49
 */
public class Client {

    public void assemble() {
        // 创建接收者
        Receiver receiver = new Receiver();
        // 创建命令对象，设定它的接收者
        Command command = new ConCreteCommand(receiver);
        // 创建Invoker，把命令对象设置进去
        Invoker invoker = new Invoker();
        invoker.setCommand(command);
    }
}
