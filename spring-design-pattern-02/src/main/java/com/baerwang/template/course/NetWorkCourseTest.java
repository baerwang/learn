package com.baerwang.template.course;

/**
 * @author baerwang
 * @since 2020/9/21 11:38
 */
public class NetWorkCourseTest {

    public static void main(String[] args) {
        System.out.println("---Java架构师课程---");
        NetWorkCourse course = new JavaSource();
        course.createCourse();

        System.out.println("---大数据课程---");
        BigDataCourse bigDataCourse = new BigDataCourse(true);
        bigDataCourse.createCourse();
    }
}
