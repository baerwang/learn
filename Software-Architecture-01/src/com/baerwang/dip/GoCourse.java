package com.baerwang.dip;

/**
 * @author baerwang
 * @since 2020/8/23 19:34
 */
public class GoCourse implements ICourse {

    @Override
    public void study() {
        System.out.println("Tom在学习Go的课程");
    }
}
