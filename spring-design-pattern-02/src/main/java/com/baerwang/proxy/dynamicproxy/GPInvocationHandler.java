package com.baerwang.proxy.dynamicproxy;

import java.lang.reflect.Method;

/**
 * @author baerwang
 * @since 2020/9/2 11:09
 */
public interface GPInvocationHandler {

    Object invoke(Object proxy, Method method, Object[] args) throws Throwable;

}
