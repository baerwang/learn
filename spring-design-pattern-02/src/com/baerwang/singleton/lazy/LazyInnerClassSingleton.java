package com.baerwang.singleton.lazy;

/**
 * 类初始化，采用静态内部类的方式
 * 兼顾了饿汉式单例模式的内存浪费问题和synchronized的性能问题。
 * 内部类要在方法调用之前初始化，巧妙低避免了线程安全问题
 *
 * @author baerwang
 * @since 2020/8/31
 */
public class LazyInnerClassSingleton {

    /**
     * 使用LazyInnerClassSingleton的时候，默认会先初始化内部类
     * 没使用，则内部类是不加载的
     */
    private LazyInnerClassSingleton() {
        if (LazyHolder.LAZY_INNER_CLASS_SINGLETON != null) {
            throw new RuntimeException("不允许创建多个实例");
        }
    }

    /**
     * 每一个关键字都不是多余的，static是为了单例的空间共享，保证这个方法不会被重写，重载
     *
     * @return
     */
    public static final LazyInnerClassSingleton getInstance() {
        // 在返回结果，一定会加载内部类
        return LazyHolder.LAZY_INNER_CLASS_SINGLETON;
    }

    private static class LazyHolder {
        private static final LazyInnerClassSingleton LAZY_INNER_CLASS_SINGLETON = new LazyInnerClassSingleton();
    }
}
