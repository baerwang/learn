package com.baerwang.strategypattern;

/**
 * @author baerwang
 * @since 2020/9/16 17:05
 */
public class GroupbuyStrategy implements PromotionStrategy {

    @Override
    public void doPromotion() {
        System.out.println("拼团，满20个人成团，全团享受团购价");
    }
}
