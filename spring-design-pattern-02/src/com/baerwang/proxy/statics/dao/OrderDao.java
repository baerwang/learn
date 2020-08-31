package com.baerwang.proxy.statics.dao;

import com.baerwang.proxy.statics.entity.Order;

/**
 * @author baerwang
 * @since 2020/8/30 6:21
 */
public class OrderDao {

    public int insert(Order order) {
        System.out.println("Dao创建Order对象成功！");
        return 1;
    }
}
