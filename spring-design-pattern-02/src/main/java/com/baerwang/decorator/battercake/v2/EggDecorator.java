package com.baerwang.decorator.battercake.v2;

/**
 * @author baerwang
 * @since 2020/9/24 17:28
 */
public class EggDecorator extends BaseBatterCakeDecorator {

    public EggDecorator(BaseBatterCake baseBatterCake) {
        super(baseBatterCake);
    }

    @Override
    protected void doSomething() {

    }

    @Override
    protected String getMsg() {
        return super.getMsg() + "1个鸡蛋";
    }

    @Override
    protected int gerPrice() {
        return super.gerPrice() + 1;
    }
}
