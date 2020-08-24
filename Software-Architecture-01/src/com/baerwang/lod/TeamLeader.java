package com.baerwang.lod;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baerwang
 * @since 2020/8/25 6:42
 */
public class TeamLeader {

    public void checkNumberOfCourses() {
        List<Course> courseList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            courseList.add(new Course());
        }
        System.out.println("目前已发布的课程数量是：" + courseList.size());
    }
}
