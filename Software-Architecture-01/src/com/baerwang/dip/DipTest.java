package com.baerwang.dip;

/**
 * 依赖倒置原则（Dependence Inversion Principle DIP）
 * <p>
 * 依赖倒置原则是指设计代码结构时，高层模块不应该依赖底层模块，二者都应该依赖其抽象。
 * 抽象不应该依赖细节，细节应该依赖抽象。通过依赖倒置，可以减少类与类之间的耦合性，提高系统的稳定性，提高代码的可读性和可维护性。
 * 并且能够降低修改程序所造成的风险。
 * </p>
 * <p>
 * 抽象为基准比以细节基准搭建起来的架构要稳定得多，在拿到需求之后，要面向接口编程，在顶层再细节地设计代码结构。
 * </p>
 *
 * @author baerwang
 * @since 2020/8/23 19:25
 */
public class DipTest {

    public static void main(String[] args) {
        // Tom tom = new Tom(new JavaCourse());
        Tom tom = new Tom();
        tom.setCourse(new JavaCourse());
        tom.study();
        tom.setCourse(new GoCourse());
        tom.study();
    }

}
