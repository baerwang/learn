package com.baerwang.simplefactory;

/**
 * @author baerwang
 * @since 2020/8/27 6:55
 */
public class CourseFactory {

    /**
     * 如果增加一个课程，就要修改代码逻辑，不符合开闭原则
     *
     * @param name
     * @return
     */
    public ICourse create(String name) {
        if ("java".equals(name)) {
            return new JavaCourse();
        } else if ("go".equals(name)) {
            return new GoCourse();
        }
        return null;
    }

    public ICourse proxyCreate(Class<? extends ICourse> className) throws Exception {
        if (null != className) {
            return className.newInstance();
        }
        return null;
    }
}
