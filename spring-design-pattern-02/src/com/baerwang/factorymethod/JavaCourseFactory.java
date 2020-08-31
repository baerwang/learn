package com.baerwang.factorymethod;

import com.baerwang.simplefactory.ICourse;
import com.baerwang.simplefactory.JavaCourse;

/**
 * @author baerwang
 * @since 2020/8/28
 */
public class JavaCourseFactory implements ICourseFactory {

    @Override
    public ICourse create() {
        return new JavaCourse();
    }

}
