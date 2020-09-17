package com.baerwang.strategypattern.payport;

/**
 * @author baerwang
 * @since 2020/9/17 16:19
 */
public class JDPay extends Payment {

    @Override
    public String getName() {
        return "京东白条";
    }

    @Override
    protected double queryBalance(String id) {
        return 500;
    }
}
