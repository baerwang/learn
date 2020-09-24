package com.baerwang.decorator.battercake.v2;

/**
 * @author baerwang
 * @since 2020/9/24 16:46
 */
public class BatterCake extends BaseBatterCake {

    @Override
    protected String getMsg() {
        return "煎饼";
    }

    @Override
    protected int gerPrice() {
        return 5;
    }
}
