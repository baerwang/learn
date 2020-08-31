package com.baerwang.singleton.lazy;

import com.baerwang.singleton.lazy.LazyDoubleCheckSingleton;

/**
 * @author baerwang
 * @since 2020/8/28
 */
public class ExectorThread implements Runnable {

    @Override
    public void run() {
        // LazySimpleSingleton instance = LazySimpleSingleton.getInstance();
        // LazySimpleSingleton instance = LazySimpleSingleton.getInstances();
        LazyDoubleCheckSingleton instance = LazyDoubleCheckSingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + ":" + instance);
    }
}
