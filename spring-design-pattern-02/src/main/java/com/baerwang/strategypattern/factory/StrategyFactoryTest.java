package com.baerwang.strategypattern.factory;

import com.baerwang.strategypattern.PromotionActivity;

/**
 * @author baerwang
 * @since 2020/9/16 18:22
 */
public class StrategyFactoryTest {

    public static void main(String[] args) {
        new PromotionActivity(PromotionStrategyFactory.getPromotionStrategy("GROUPBUY")).execute();
    }
}
