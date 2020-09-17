package com.baerwang.strategypattern.payport;

/**
 * @author baerwang
 * @since 2020/9/17 16:25
 */
public class Order {

    private String id;

    private String orderId;

    private double amount;

    public Order(String id, String orderId, double amount) {
        this.id = id;
        this.orderId = orderId;
        this.amount = amount;
    }

    public PayState pay() {
        return pay(PayStrategy.DEFAULT_PAY);
    }

    public PayState pay(String payKey) {
        Payment payment = PayStrategy.get(payKey);
        System.out.println("欢迎使用" + payment.getName());
        System.out.println("本次交易金额位：" + amount + "，开始扣款...");
        return payment.pay(id, amount);
    }
}
