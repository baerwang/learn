package com.baerwang.abastractfactory;

/**
 * @author baerwang
 * @since 2020/8/28
 */
public interface CourseFactory {

    INote createNode();

    IVideo createVideo();
}
