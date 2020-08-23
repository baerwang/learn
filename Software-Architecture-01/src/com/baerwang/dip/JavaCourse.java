package com.baerwang.dip;

/**
 * @author baerwang
 * @since 2020/8/23 19:33
 */
public class JavaCourse implements ICourse {

    @Override
    public void study() {
        System.out.println("Tom在学习Java的课程");
    }
}
