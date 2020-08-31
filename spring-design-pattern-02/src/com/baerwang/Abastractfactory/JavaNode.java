package com.baerwang.Abastractfactory;

/**
 * @author baerwang
 * @since 2020/8/28
 */
public class JavaNode implements INote {

    @Override
    public void edit() {
        System.out.println("编写Java笔记");
    }
}
