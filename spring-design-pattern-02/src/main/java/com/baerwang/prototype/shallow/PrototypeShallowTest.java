package com.baerwang.prototype.shallow;

import java.util.ArrayList;

/**
 * 原型模式（Prototype Pattern）
 * <p>
 * 原型模型是指原型实例指定创建对象的种类，并且通过复制这些原型创建新的对象。
 * </p>
 * 适用场景
 * <p>
 * 1.类初始化消耗资源较多
 * 2.使用new生成一个对象需要非常频繁的过程（数据准备，访问权限等）
 * 3.构造函数比较复杂
 * 4.在循环体中产生大量对象
 * </p>
 *
 * @author baerwang
 * @since 2020/8/29 8:30
 */
public class PrototypeShallowTest {

    public static void main(String[] args) {
        // 克隆的对象
        ConcretePrototypeA concretePrototype = new ConcretePrototypeA();
        concretePrototype.setAge(18);
        concretePrototype.setName("prototype");
        concretePrototype.setHobbies(new ArrayList<String>());

        // 创建client，开始克隆对象
        Client client = new Client(concretePrototype);
        ConcretePrototypeA concretePrototypeClone = (ConcretePrototypeA) client.startClone(concretePrototype);
        System.out.println(concretePrototypeClone);

        System.out.println("原对象中引用类型中地址值：" + concretePrototype.getHobbies());
        System.out.println("克隆对象中引用类型地址值：" + concretePrototypeClone.getHobbies());
        /*
            hobbies的引用地址是相同的，意味着复制的不是值，而是引用地址。这样的话，修改任意一个对象的属性值，
            则concretePrototype和concretePrototypeClone的hobbies值都会改变，这就是浅克隆。
            浅克隆只是完整复制了值类型数据，没有赋值引用对象。
        */
        System.out.println("对象地址比较" + (concretePrototype.getHobbies() == concretePrototypeClone.getHobbies()));
    }
}
