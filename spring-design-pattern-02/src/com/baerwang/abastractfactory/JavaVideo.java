package com.baerwang.abastractfactory;

/**
 * @author baerwang
 * @since 2020/8/28
 */
public class JavaVideo implements IVideo {

    @Override
    public void record() {
        System.out.println("录制Java课程");
    }
}
