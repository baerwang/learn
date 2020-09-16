package com.baerwang.delegate.company;

import java.util.HashMap;
import java.util.Map;

/**
 * @author baerwang
 * @since 2020/9/16 15:43
 */
public class Leader implements IEmployee {

    private Map<String, IEmployee> targets = new HashMap<>();

    public Leader() {
        targets.put("加密", new EmployeeA());
        targets.put("登录", new EmployeeB());
    }

    /**
     * 项目经理不干活
     *
     * @param command
     */
    @Override
    public void doing(String command) {
        targets.get(command).doing(command);
    }
}
