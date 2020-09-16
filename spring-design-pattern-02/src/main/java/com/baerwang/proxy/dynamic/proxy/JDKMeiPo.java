package com.baerwang.proxy.dynamic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author baerwang
 * @since 2020/8/30 11:42
 */
public class JDKMeiPo implements InvocationHandler {

    /**
     * 被代理的对象，把引用保存下来
     */
    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        Class<?> aClass = target.getClass();
        return Proxy.newProxyInstance(aClass.getClassLoader(), aClass.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object obj = method.invoke(this.target, args);
        after();
        return obj;
    }

    public void before() {
        System.out.println("媒婆 找对象 确认你的需求");
    }

    public void after() {
        System.out.println("办事情");
    }
}
