package com.baerwang.proxy.statics.proxy;

import com.baerwang.proxy.statics.db.DynamicDataSourceEntry;
import com.baerwang.proxy.statics.service.OrderService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author baerwang
 * @since 2020/8/30 11:53
 */
public class OrderServiceDynamicProxy implements InvocationHandler {

    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        Class<?> aClass = target.getClass();
        return Proxy.newProxyInstance(aClass.getClassLoader(), aClass.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before(args[0]);
        Object invoke = method.invoke(target, args);
        after();
        return invoke;
    }

    private void before(Object target) {
        try {
            System.out.println("proxy before method.");
            Long createTime = (Long) target.getClass().getMethod("getCreateTime").invoke(target);
            System.out.println("动态代理类自动分配 db:" + createTime + "数据源处理数据");
            DynamicDataSourceEntry.set(createTime.intValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void after() {
        System.out.println("Proxy after method.");
    }
}
