package com.baerwang.strategypattern.payport;

/**
 * @author baerwang
 * @since 2020/9/17 16:07
 */
public abstract class Payment {

    /**
     * 支付类型
     *
     * @return
     */
    public abstract String getName();

    /**
     * 查询余额
     *
     * @param id
     * @return
     */
    protected abstract double queryBalance(String id);

    /**
     * 扣款支持
     *
     * @param id
     * @param amount
     * @return
     */
    public PayState pay(String id, double amount) {
        if (queryBalance(id) < amount) {
            return new PayState(500, "支付失败，余额不足");
        }
        return new PayState(200, "支付成功，支付金额：" + amount);
    }


}
