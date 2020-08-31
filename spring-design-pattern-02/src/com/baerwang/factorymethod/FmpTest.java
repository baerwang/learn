package com.baerwang.factorymethod;

/**
 * 工厂方法模型（Factory Method Pattern）
 * <p>
 * 工厂方法模型是指定义一个创建对象的接口，但让实现这个接口的类来决定实例化哪个类，工厂方法模型让类的实例化推迟到子类中进行。
 * 在工厂方法模型中用户只需要关心所需产品对应的工厂，无须关心创建细节，而且加入新的产品时符合开闭原则。
 * </p>
 * 适用场景
 * <p>
 * 1.创建对象需要大量重复的代码
 * 2.客户端（应用层）不依赖于产品类实例如何被创建，如何被实现等细节。
 * 3.一个类通过其子类来创建指定哪个对象
 * </p>
 * 缺点
 * <p>
 * 1.类的个数容易过多，增加复杂度
 * 2.增加了系统的抽象性和理解难度
 * </p>
 *
 * @author baerwang
 * @since 2020/8/28
 */
public class FmpTest {

    public static void main(String[] args) {
        ICourseFactory factory = new GoCourseFactory();
        factory.create().record();

        factory = new JavaCourseFactory();
        factory.create().record();
    }
}
