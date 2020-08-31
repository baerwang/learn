package com.baerwang.singleton.lazy;

/**
 * 懒汉单例模式
 *
 * @author baerwang
 * @since 2020/8/28
 */
public class LazySimpleSingleton {

    private static LazySimpleSingleton SINGLETON = null;

    /**
     * 线程不安全
     *
     * @return
     */
    public static LazySimpleSingleton getInstance() {
        if (SINGLETON == null) {
            SINGLETON = new LazySimpleSingleton();
        }
        return SINGLETON;
    }

    /**
     * 线程安全，但是有缺点，加锁时，在线程数量比较多的情况下，cpu分配压力上升，会导致大批线程阻塞，导致系统性能下降
     *
     * @return
     */
    public static synchronized LazySimpleSingleton getInstances() {
        if (SINGLETON == null) {
            SINGLETON = new LazySimpleSingleton();
        }
        return SINGLETON;
    }

}
