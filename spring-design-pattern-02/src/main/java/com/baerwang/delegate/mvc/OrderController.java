package com.baerwang.delegate.mvc;

/**
 * @author baerwang
 * @since 2020/9/16 15:54
 */
public class OrderController {

    public void getOrderById(String mid) {
        System.out.println("你的订单编号为" + mid + "，正在支付中...");
    }
}
