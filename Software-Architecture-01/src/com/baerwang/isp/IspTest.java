package com.baerwang.isp;

/**
 * 接口隔离原则（Interface Segregation Principle，ISP）
 * 接口隔离是指多个专门的接口，而不使用单一的总接口，客户端不应该依赖它不需要的接口，设计接口注意几点：
 * （1）一个类对另一个类的依赖应该建立在最小的接口之上
 * （2）建立单一接口，不要建立庞大臃肿的接口。
 * （3）尽量细化接口，接口中的方法尽量少（不是越少越好，一定要适度）
 * 接口隔离原则符合我们常说的高内聚、低耦合的设计思想，可以使类具有很好的可读性、可扩展性和可维护性。
 *
 * @author baerwang
 * @since 2020/8/25 6:21
 */
public class IspTest {

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();
        Bird bird = new Bird();
        bird.fly();
    }
}
