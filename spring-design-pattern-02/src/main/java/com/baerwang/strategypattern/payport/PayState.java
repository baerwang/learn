package com.baerwang.strategypattern.payport;

/**
 * @author baerwang
 * @since 2020/9/17 16:15
 */
public class PayState {

    private int code;

    private String msg;

    public PayState(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return ("支付状态：[" + code + "]，" + msg);
    }
}
