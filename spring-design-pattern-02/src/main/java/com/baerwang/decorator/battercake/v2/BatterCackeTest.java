package com.baerwang.decorator.battercake.v2;

/**
 * @author baerwang
 * @since 2020/9/24 17:32
 */
public class BatterCackeTest {

    public static void main(String[] args) {
        BaseBatterCake baseBatterCake;
        // 买一个煎饼
        baseBatterCake = new BatterCake();

        // 加一个鸡蛋
        baseBatterCake = new EggDecorator(baseBatterCake);

        // 加根火腿
        baseBatterCake = new SausageDecorator(baseBatterCake);

        System.out.println(baseBatterCake.getMsg() + "，总价：" + baseBatterCake.gerPrice());
    }
}
