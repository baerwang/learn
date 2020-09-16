package com.baerwang.simplefactory;

/**
 * @author baerwang
 * @since 2020/8/27 6:54
 */
public class GoCourse implements ICourse {

    @Override
    public void record() {
        System.out.println("录制Go课程");
    }
}
