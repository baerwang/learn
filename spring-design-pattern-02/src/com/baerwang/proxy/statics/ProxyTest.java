package com.baerwang.proxy.statics;

import com.baerwang.proxy.service.impl.OrderServiceImpl;
import com.baerwang.proxy.statics.entity.Order;
import com.baerwang.proxy.statics.proxy.OrderServiceDynamicProxy;
import com.baerwang.proxy.statics.proxy.OrderServiceStaticProxy;
import com.baerwang.proxy.statics.service.OrderService;

/**
 * 静态代理
 *
 * @author baerwang
 * @since 2020/8/30 6:40
 */
public class ProxyTest {

    public static void main(String[] args) {
        // 全局
        Order order = new Order();
        order.setCreateTime(2021L);
        // 静态
        OrderService orderServiceStaticProxy = new OrderServiceStaticProxy(new OrderServiceImpl());
        orderServiceStaticProxy.createOrder(order);
        // 动态
        OrderService orderServiceDynamicProxy = (OrderService) new OrderServiceDynamicProxy().getInstance(new OrderServiceImpl());
        orderServiceDynamicProxy.createOrder(order);
    }
}
