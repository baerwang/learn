package com.baerwang.delegate.company;

/**
 * @author baerwang
 * @since 2020/9/16 15:43
 */
public class EmployeeB implements IEmployee {

    @Override
    public void doing(String command) {
        System.out.println("我是员工B，现在开始干" + command + "工作");
    }
}
