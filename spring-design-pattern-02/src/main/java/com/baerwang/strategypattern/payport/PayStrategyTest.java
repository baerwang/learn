package com.baerwang.strategypattern.payport;

/**
 * @author baerwang
 * @since 2020/9/17 16:29
 */
public class PayStrategyTest {

    public static void main(String[] args) {
        Order order = new Order("1", "2xx", 100.20);
        System.out.println(order.pay(PayStrategy.JD_PAY));
    }
}
