package com.baerwang.strategypattern.payport;

/**
 * @author baerwang
 * @since 2020/9/17 16:17
 */
public class AliPay extends Payment {

    @Override
    public String getName() {
        return "支付宝";
    }

    @Override
    protected double queryBalance(String id) {
        return 900;
    }
}
