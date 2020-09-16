package com.baerwang.singleton.register;

import java.lang.reflect.Constructor;

/**
 * 破坏枚举单例
 *
 * @author baerwang
 * @since 2020/8/31 17:11
 */
public class EnumSingletonDamgeTest {

    public static void main(String[] args) throws Exception {
        Class<EnumSingleton> enumSingletonClass = EnumSingleton.class;
        Constructor<EnumSingleton> declaredConstructor = enumSingletonClass.getDeclaredConstructor();
        declaredConstructor.newInstance(null);
        System.out.println(enumSingletonClass);
    }
}
