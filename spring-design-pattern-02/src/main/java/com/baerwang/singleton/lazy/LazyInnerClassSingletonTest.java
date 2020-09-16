package com.baerwang.singleton.lazy;

import java.lang.reflect.Constructor;

/**
 * 反射破坏单例
 *
 * @author baerwang
 * @since 2020/8/31
 */
public class LazyInnerClassSingletonTest {

    public static void main(String[] args) throws Exception {
        Class<LazyInnerClassSingleton> lazyInnerClassSingletonClass = LazyInnerClassSingleton.class;
        Constructor<LazyInnerClassSingleton> declaredConstructor = lazyInnerClassSingletonClass.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        LazyInnerClassSingleton lazyInnerClassSingleton = declaredConstructor.newInstance(null);
        LazyInnerClassSingleton lazyInnerClassSingleton1 = declaredConstructor.newInstance(null);

        System.out.println(lazyInnerClassSingleton == lazyInnerClassSingleton1);


    }
}
