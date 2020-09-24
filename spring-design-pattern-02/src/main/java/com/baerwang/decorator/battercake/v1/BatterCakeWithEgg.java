package com.baerwang.decorator.battercake.v1;

/**
 * @author baerwang
 * @since 2020/9/24 16:17
 */
public class BatterCakeWithEgg extends BatterCake {

    @Override
    protected String getMsg() {
        return super.getMsg() + "加一个鸡蛋";
    }

    /**
     * 加个蛋
     */
    @Override
    public int getPrice() {
        return super.getPrice() + 1;
    }
}
