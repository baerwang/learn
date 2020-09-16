package com.baerwang.strategypattern.factory;

import com.baerwang.strategypattern.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author baerwang
 * @since 2020/9/16 18:02
 */
public class PromotionStrategyFactory {

    private static Map<String, PromotionStrategy> PROMOTION_STRATEGY_MAP = new HashMap<>();

    static {
        PROMOTION_STRATEGY_MAP.put("COUPON", new CouponStrategy());
        PROMOTION_STRATEGY_MAP.put("CASHBACK", new CashbackStrategy());
        PROMOTION_STRATEGY_MAP.put("GROUPBUY", new GroupbuyStrategy());
    }

    private static final PromotionStrategy NON_PROMOTION = new EmptyStrategy();

    private PromotionStrategyFactory() {
    }

    public static PromotionStrategy getPromotionStrategy(String promotionKey) {
        PromotionStrategy promotionStrategy = PROMOTION_STRATEGY_MAP.get(promotionKey);
        return promotionStrategy == null ? NON_PROMOTION : promotionStrategy;
    }

}
