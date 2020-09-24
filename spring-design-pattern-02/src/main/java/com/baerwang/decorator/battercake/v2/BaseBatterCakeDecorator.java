package com.baerwang.decorator.battercake.v2;

/**
 * @author baerwang
 * @since 2020/9/24 16:49
 */
public abstract class BaseBatterCakeDecorator extends BatterCake {

    private BaseBatterCake baseBatterCake;

    public BaseBatterCakeDecorator(BaseBatterCake baseBatterCake) {
        this.baseBatterCake = baseBatterCake;
    }

    protected abstract void doSomething();

    @Override
    protected String getMsg() {
        return this.baseBatterCake.getMsg();
    }

    @Override
    protected int gerPrice() {
        return this.baseBatterCake.gerPrice();
    }
}
