package com.baerwang.lsp;

import com.baerwang.ocp.JavaCourse;

/**
 * 里氏替换（Liskov Substitution Principle，LSP)
 * <p>
 * 里氏替换是指如果对每一个类型为T1的对象o1，都有类型为T2的对象为T2的对象O2，使得以T1定义的所有程序P在所有的对象O1都替换成02时，
 * 程序P的行为都没有发生变化，那么类型T2是类型T1的子类型。
 * </p>
 * <p>
 * 可以理解为一个软件实体如果适用于一个父类，那么一定适用于其子类，所有引用父类的地方必须能透明地使用其子类的对象，子类对象能够替换
 * 父类对象，而程序逻辑不变。根据这个理解，引申含义为：子类可以扩展父类的功能，但不能改变父类原有的功能。
 * （1）子类可以实现父类的抽象方法，但不能覆盖父类的非抽象方法。
 * （2）子类可以增加自己持有的方法。
 * （3）当子类的方法重载父类的方法时，方法的前置条件（即方法的输入/入参）要比父类方法的输入参数更宽松。
 * （4）当子类的方法重载父类的方法（重写/重载或实现抽象方法），方法的后置条件（即方法的输出/返回值）要比父类更严格或于父类一样。
 * </p>
 * <p>
 * 优点：
 * （1）约束继承泛滥，是开闭原则的一种体现。
 * （2）加强程序的强壮性，同时变更时也可以做到非常号的兼容性，提高程序的可维护性和扩展性，降低需求变更时引入的风险。
 * </p>
 *
 * @author baerwang
 * @since 2020/8/25 21:42
 */
public class LspTest {

    public static void main(String[] args) {
        /*JavaCourse javaCourse = new JavaCourse(1, "大数据", 100.0);
        // 如果Java大数据课程是否有优惠,那么这个时候我们不能再修改源代码,如果修改源代码,其他人也可以获得这个优惠了,
        // 我们可以新增一个功能去继承Java课程来设置优惠
        JavaDiscountCourse discountCourse = new JavaDiscountCourse(javaCourse);
        // 原价
        System.out.println(discountCourse.getName() + "课程原价：" + discountCourse.getPrice());
        System.out.println(discountCourse.getName() + "课程优惠：" + discountCourse.getDiscountPrice());*/

        /*Rectangle rectangle = new Rectangle();
        rectangle.setWidth(20);
        rectangle.setHeight(10);
        resize(rectangle);*/

        Square square = new Square();
        square.setLength(10);
        resize(square);
    }

    private static void resize(Rectangle rectangle) {
        while (rectangle.getWidth() >= rectangle.getHeight()) {
            rectangle.setHeight(rectangle.getHeight() + 1);
            System.out.println("width：" + rectangle.getWidth() + "，height：" + rectangle.getHeight());
        }
        System.out.println("resize 方法结束");
    }
}
