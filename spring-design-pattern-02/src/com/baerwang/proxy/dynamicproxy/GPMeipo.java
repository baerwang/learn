package com.baerwang.proxy.dynamicproxy;

import java.lang.reflect.Method;

/**
 * @author baerwang
 * @since 2020/9/2 17:28
 */
public class GPMeipo implements GPInvocationHandler {

    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        Class<?> aClass = target.getClass();
        return GPProxy.newProxyInstance(new GPClassLoader(), aClass.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        method.invoke(this.target, args);
        after();
        return null;
    }

    private void before() {
        System.out.println("媒婆帮找对象，确认您的需求");
    }

    private void after() {
        System.out.println("GoGoGoGo");
    }
}
