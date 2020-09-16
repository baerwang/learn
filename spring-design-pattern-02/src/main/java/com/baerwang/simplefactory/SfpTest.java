package com.baerwang.simplefactory;

/**
 * 简单工厂模式（Simple Factory Pattern)
 * <p>
 * 简单工厂模式是指由一个工厂对象决定创建哪一种产品类的实例，但它不属于Gof的23种设计模式。
 * 简单工厂模式适用于工厂类负责创建的对象较少的场景，且客户端只需要传入工厂类的参数，对于如何创建对象不需要关心。
 * </p>
 * <p>
 * 缺点：
 * 工厂类的职责相对过重，不易于扩展过于复杂的产品结构
 * </p>
 *
 * @author baerwang
 * @since 2020/8/27 6:49
 */
public class SfpTest {

    public static void main(String[] args) throws Exception {
        // 客户端调用
        /* ICourse course = new JavaCourse();
        course.record();*/
        // 调用工厂模式
        CourseFactory courseFactory = new CourseFactory();
        // courseFactory.create("java").record();

        ICourse course = courseFactory.proxyCreate(GoCourse.class);
        course.record();
    }
}
