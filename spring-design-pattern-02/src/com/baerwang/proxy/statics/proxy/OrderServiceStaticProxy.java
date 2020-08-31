package com.baerwang.proxy.statics.proxy;

import com.baerwang.proxy.statics.db.DynamicDataSourceEntry;
import com.baerwang.proxy.statics.entity.Order;
import com.baerwang.proxy.statics.service.OrderService;

/**
 * 静态代理
 * @author baerwang
 * @since 2020/8/30 6:35
 */
public class OrderServiceStaticProxy implements OrderService {

    private OrderService orderService;

    public OrderServiceStaticProxy(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public int createOrder(Order order) {
        before();
        Long createTime = order.getCreateTime();
        System.out.println("静态代理类自动分配 db:" + createTime + "数据源处理数据");
        DynamicDataSourceEntry.set(createTime.intValue());
        orderService.createOrder(order);
        after();
        return 0;
    }

    public void before() {
        System.out.println("Proxy before method.");
    }

    public void after() {
        System.out.println("Proxy after method.");
    }
}
