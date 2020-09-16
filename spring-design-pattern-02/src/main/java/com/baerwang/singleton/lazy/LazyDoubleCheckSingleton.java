package com.baerwang.singleton.lazy;

/**
 * 双重检查锁的单例模式
 * 兼顾线程安全又能提升程序性能
 * 使用 synchronzied上锁还是有点影响的
 *
 * @author baerwang
 * @since 2020/8/31
 */
public class LazyDoubleCheckSingleton {

    private volatile static LazyDoubleCheckSingleton lazyDoubleCheckSingleton = null;

    private LazyDoubleCheckSingleton() {
    }

    public static LazyDoubleCheckSingleton getInstance() {
        if (lazyDoubleCheckSingleton == null) {
            synchronized (LazyDoubleCheckSingleton.class) {
                lazyDoubleCheckSingleton = new LazyDoubleCheckSingleton();
            }
        }
        return lazyDoubleCheckSingleton;
    }
}
