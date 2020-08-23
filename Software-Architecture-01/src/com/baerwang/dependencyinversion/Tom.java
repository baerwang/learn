package com.baerwang.dependencyinversion;

/**
 * @author baerwang
 * @since 2020/8/23 19:22
 */
public class Tom {

    private ICourse iCourse;

    public Tom() {
    }

    public Tom(ICourse iCourse) {
        this.iCourse = iCourse;
    }

    public ICourse getCourse() {
        return iCourse;
    }

    public void setCourse(ICourse iCourse) {
        this.iCourse = iCourse;
    }

    public void study() {
        this.iCourse.study();
    }
}
