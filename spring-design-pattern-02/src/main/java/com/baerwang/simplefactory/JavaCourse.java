package com.baerwang.simplefactory;

/**
 * @author baerwang
 * @since 2020/8/27 6:52
 */
public class JavaCourse implements ICourse {

    @Override
    public void record() {
        System.out.println("录制Java课程");
    }
}
