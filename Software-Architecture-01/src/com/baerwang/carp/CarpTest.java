package com.baerwang.carp;

/**
 * 合成复用（Composite/Aggregate Reuse Principle，CARP）
 * <p>
 * 合成复用是指尽量使用对象组合（has-a）/聚合（contanis-a）而不是继承关系达到软件复用的目的。
 * 可以使系统更加灵活，降低类与类之间的耦合度，一个类的变化对其他类造成的影响相对较少。
 * 继承叫做白箱复用，相当于把所有的实现细节暴力给子类。组合/聚合称为黑箱复用，我们是无法获取到类以外的对象的实现细节。
 * 我们要根据具体的业务场景来做代码设计，但也需要遵循OOP（面向对象）模型。
 * </p>
 *
 * @author baerwang
 * @since 2020/8/26 6:27
 */
public class CarpTest {

    public static void main(String[] args) {
        ProductDao productDao = new ProductDao();
        productDao.setDbConnection(new OracleConnection());
        productDao.addProduct();
    }
}
