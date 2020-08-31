package com.baerwang.Abastractfactory;

/**
 * @author baerwang
 * @since 2020/8/28
 */
public class JavaCourseFactory implements CourseFactory {

    @Override
    public INote createNode() {
        return new JavaNode();
    }

    @Override
    public IVideo createVideo() {
        return new JavaVideo();
    }
}
