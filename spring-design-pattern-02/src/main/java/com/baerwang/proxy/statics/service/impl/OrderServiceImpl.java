package com.baerwang.proxy.statics.service.impl;

import com.baerwang.proxy.statics.dao.OrderDao;
import com.baerwang.proxy.statics.entity.Order;
import com.baerwang.proxy.statics.service.OrderService;

/**
 * @author baerwang
 * @since 2020/8/30 6:23
 */
public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao;

    public OrderServiceImpl() {
        this.orderDao = new OrderDao();
    }

    @Override
    public int createOrder(Order order) {
        System.out.println("service调用orderDao创建订单");
        return orderDao.insert(order);
    }
}
