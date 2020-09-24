package com.baerwang.decorator.battercake.v2;

/**
 * @author baerwang
 * @since 2020/9/24 17:31
 */
public class SausageDecorator extends BaseBatterCakeDecorator {

    public SausageDecorator(BaseBatterCake baseBatterCake) {
        super(baseBatterCake);
    }

    @Override
    protected void doSomething() {

    }

    @Override
    protected String getMsg() {
        return super.getMsg() + "1根火腿";
    }

    @Override
    protected int gerPrice() {
        return super.gerPrice() + 2;
    }
}
