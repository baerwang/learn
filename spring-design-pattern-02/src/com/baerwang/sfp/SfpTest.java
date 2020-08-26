package com.baerwang.sfp;

/**
 * 简单工厂模式（Simple Factory Pattern)
 * <p>
 * 简单工厂模式是指由一个工厂对象决定创建哪一种产品类的实例，但它不属于Gof的23种设计模式。
 * 简单工厂模式适用于工厂类负责创建的对象较少的场景，且客户端只需要传入工厂类的参数，对于如何创建对象不需要关心。
 * </p>
 *
 * @author baerwang
 * @since 2020/8/27 6:49
 */
public class SfpTest {

    public static void main(String[] args) {
        // 客户端调用
        /* ICourse course = new JavaCourse();
        course.record();*/
        // 调用工厂模式
        new CourseFactory().create("java").record();
    }
}
