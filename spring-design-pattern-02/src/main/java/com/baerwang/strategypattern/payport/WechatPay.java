package com.baerwang.strategypattern.payport;

/**
 * @author baerwang
 * @since 2020/9/17 16:18
 */
public class WechatPay extends Payment {


    @Override
    public String getName() {
        return "微信支付";
    }

    @Override
    protected double queryBalance(String id) {
        return 256;
    }
}
