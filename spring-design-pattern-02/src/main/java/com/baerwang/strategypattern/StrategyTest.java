package com.baerwang.strategypattern;

/**
 * 策略模式（Strategy pattern）
 * <p>
 * 策略模式是指定义了算法家族并分别封装起来，让它们之间可以互相替换 ，此模式使得算法的变化不会影响使用算法的用户。
 * </p>
 *
 * @author baerwang
 * @since 2020/9/16 17:07
 */
public class StrategyTest {

    public static void main(String[] args) {
        /*PromotionActivity promotionActivity = new PromotionActivity(new CouponStrategy());
        PromotionActivity promotionActivity1 = new PromotionActivity(new CashbackStrategy());

        promotionActivity.execute();
        promotionActivity1.execute();*/

        PromotionActivity promotionActivity = null;
        String promotionKey = "COUPON";
        if ("COUPON".equals(promotionKey)) {
            promotionActivity = new PromotionActivity(new CouponStrategy());
        } else if ("CASHBACK".equals(promotionKey)) {
            promotionActivity = new PromotionActivity(new CashbackStrategy());
        }

        promotionActivity.execute();
    }
}
