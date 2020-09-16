package com.baerwang.strategypattern;

/**
 * @author baerwang
 * @since 2020/9/16 17:56
 */
public class EmptyStrategy implements PromotionStrategy {

    @Override
    public void doPromotion() {
        System.out.println("无促销活动");
    }
}
