package com.baerwang.sfp;

/**
 * @author baerwang
 * @since 2020/8/27 6:55
 */
public class CourseFactory {

    public ICourse create(String name) {
        if ("java".equals(name)) {
            return new JavaCourse();
        } else if ("go".equals(name)) {
            return new GoCourse();
        }
        return null;
    }
}
