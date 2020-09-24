package com.baerwang.decorator.battercake.v1;

/**
 * @author baerwang
 * @since 2020/9/24 16:15
 */
public class BatterCakeWithEggAndSausage extends BatterCakeWithEgg {

    @Override
    protected String getMsg() {
        return super.getMsg() + "加一个香肠";
    }

    /**
     * 加个香肠
     */
    @Override
    public int getPrice() {
        return super.getPrice() + 2;
    }
}
