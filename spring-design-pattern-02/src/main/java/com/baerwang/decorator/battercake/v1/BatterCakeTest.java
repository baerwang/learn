package com.baerwang.decorator.battercake.v1;

/**
 * 装饰者（Decorator Pattern）
 * <p>
 * 装饰者是指在步改变原有对象的基础上，将功能附加到对象上，提供了比继承更有弹性的方案（扩展原有对象的功能），
 * 属于结构型模式。装饰者模式在生活中的应用也比较多，给煎饼加个蛋，加个火腿肠，都是在为对象扩展一些额外的职责。
 * </p>
 * 装饰者模式适用于以下场景：
 * （1）扩展一个类的功能或给一个类添加附加职责。
 * （2）动态给一个对象添加功能，这些功能可以在动态地撤销。
 * 装饰者优缺点：
 * 优点：
 * （1）装饰者模式试继承的有力补充，且比继承灵活，可以在不改变原有对象的情况下动态地给一个对象扩展功能，即插即用。
 * （2）使用不同的装饰类及这些类的排列组合，可以实现不同的效果。
 * （3）装饰者模式完全符合开闭原则。
 * 缺点：
 * （1）会出现更多的代码，更多的类，增加程序的复杂度性。
 * （2）动态装饰时，多层装饰会更复杂。
 *
 * @author baerwang
 * @since 2020/9/24 16:18
 */
public class BatterCakeTest {

    public static void main(String[] args) {
        BatterCake batterCake = new BatterCake();
        System.out.println(batterCake.getMsg() + ",总价格：" + batterCake.getPrice());

        BatterCake batterCakeWithEgg = new BatterCakeWithEgg();
        System.out.println(batterCakeWithEgg.getMsg() + ",总价格：" + batterCakeWithEgg.getPrice());

        BatterCake batterCakeWithEggAndSausage = new BatterCakeWithEggAndSausage();
        System.out.println(batterCakeWithEggAndSausage.getMsg() + ",总价格：" + batterCakeWithEggAndSausage.getPrice());

    }
}
