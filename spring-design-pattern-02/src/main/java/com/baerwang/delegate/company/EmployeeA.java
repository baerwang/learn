package com.baerwang.delegate.company;

/**
 * @author baerwang
 * @since 2020/9/16 15:42
 */
public class EmployeeA implements IEmployee {

    @Override
    public void doing(String command) {
        System.out.println("我是员工A，现在开始干" + command + "工作");
    }
}
