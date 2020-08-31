package com.baerwang.Abastractfactory;

/**
 * 抽象工厂模式（Abastract Factory Pattern）
 * <p>
 * 抽象工厂模式是指提供一个创建一系列相关或相互依赖对象的接口，无须指定它们的具体类。
 * 客户端（应用层）不依赖于产品类实例如何被创建，如何被实现等细节，强调的是一系列相关的产品对象（属于同一产品族）
 * 一起使用创建对象需要大量重复的代码，需要提供一个产品类的库，所有的产品以同样的接口出现，从而使客户端不依赖于具体的实现。
 * </p>
 * 缺点
 * <p>
 * 1.规定了所有可能被创建的产品集合，产品族中扩展新的产品困难，需要修改抽象工厂的接口。
 * 2.增加了系统的抽象性和理解难度。
 * </p>
 *
 * @author baerwang
 * @since 2020/8/28
 */
public class AfpTest {

    public static void main(String[] args) {
        JavaCourseFactory factory = new JavaCourseFactory();
        factory.createVideo().record();
        factory.createNode().edit();
    }
}
