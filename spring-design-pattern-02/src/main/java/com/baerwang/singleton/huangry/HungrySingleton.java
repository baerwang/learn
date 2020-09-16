package com.baerwang.singleton.huangry;

/**
 * 饿汉式单例
 * <p>
 * 适用于单例对象较少的情况
 * </p>
 *
 * @author baerwang
 * @since 2020/8/28
 */
public class HungrySingleton {

    // 初始化
    // private static final HungrySingleton SINGLETON = new HungrySingleton();

    private static final HungrySingleton SINGLETON;

    // 使用静态代码块的机制
    static {
        SINGLETON = new HungrySingleton();
    }

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return SINGLETON;
    }
}
