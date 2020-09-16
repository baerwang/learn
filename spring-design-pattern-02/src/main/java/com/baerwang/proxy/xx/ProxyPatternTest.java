package com.baerwang.proxy.xx;

/**
 * 代理模式（Proxy Pattern）
 * <p>
 * 代理模式是为其他对象提供一种代理，以控制对这个对象的访问。
 * 代理对象在客户端和目标对象之间起到中介作用，代理模式属于结构型设计模式。
 * 使用代理模式主要有两个目的：
 * 1.保护目标对象。
 * 2.增强目标对象。
 * </p>
 *
 * @author baerwang
 * @since 2020/8/30 6:11
 */
public class ProxyPatternTest {

    public static void main(String[] args) {
        Father father = new Father(new Son());
        father.findLove();
    }
}
