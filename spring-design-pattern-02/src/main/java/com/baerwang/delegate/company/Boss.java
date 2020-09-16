package com.baerwang.delegate.company;

/**
 * @author baerwang
 * @since 2020/9/16 15:45
 */
public class Boss {

    public void command(String command, Leader leader) {
        leader.doing(command);
    }
}
