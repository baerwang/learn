package com.baerwang.strategypattern.payport;

import java.util.HashMap;
import java.util.Map;

/**
 * @author baerwang
 * @since 2020/9/17 16:19
 */
public class PayStrategy {

    public static final String ALI_PAY = "AliPay";
    public static final String JD_PAY = "JdPay";
    public static final String UNION_PAY = "UnionPay";
    public static final String WECHAT_PAY = "WeChatPay";
    public static final String DEFAULT_PAY = ALI_PAY;


    private static Map<String, Payment> payStrategy = new HashMap<String, Payment>() {{
        put(ALI_PAY, new AliPay());
        put(WECHAT_PAY, new WechatPay());
        put(UNION_PAY, new UnionPay());
        put(JD_PAY, new JDPay());
    }};

    public static Payment get(String payKey) {
        if (payStrategy.containsKey(payKey)) {
            return payStrategy.get(DEFAULT_PAY);
        }
        return payStrategy.get(payKey);
    }


}
