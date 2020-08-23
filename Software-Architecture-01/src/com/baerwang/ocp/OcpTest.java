package com.baerwang.ocp;

/**
 * 开闭原则（Open-Close Principle OCP）
 * <p>
 * 开闭原则是指一个软件实体(如类，模块和函数)应该对扩展开放，对修改关闭。
 * 所谓的开闭对扩展和修改两个行为的以一个原则，它强调的是用抽象构建框架，用实现扩展细节，可以提高软件系统的可复用性及可维护性。
 * 开闭原则是面向对象设计中最基础的设计原则，它指导我们如何建立稳定，灵活的系统。例如版本更新，尽可能不修改源代码，但是可以增加新功能。
 * </p>
 *
 * @author baerwang
 * @since 2020/8/23 18:57
 */
public class OcpTest {

    public static void main(String[] args) {
        // 初始化课程 当前Java大数据课程为100快
        JavaCourse javaCourse = new JavaCourse(1, "大数据", 100.0);
        // 如果Java大数据课程是否有优惠,那么这个时候我们不能再修改源代码,如果修改源代码,其他人也可以获得这个优惠了,
        // 我们可以新增一个功能去继承Java课程来设置优惠
        JavaDiscountCourse discountCourse = new JavaDiscountCourse(javaCourse);
        // 原价
        System.out.println(discountCourse.getName() + "课程原价：" + discountCourse.getOriginPrice());
        System.out.println(discountCourse.getName() + "课程优惠：" + discountCourse.getPrice());
        // 如果我们想知道另外一个课程，只需要去创建一个类实现ICourse接口即可
        GoCourse goCourse = new GoCourse(2, "Go-Web", 105.0);
        System.out.println(goCourse.getName() + "课程原价：" + goCourse.getPrice());
    }

}
