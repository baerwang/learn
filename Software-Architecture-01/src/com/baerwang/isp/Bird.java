package com.baerwang.isp;

/**
 * @author baerwang
 * @since 2020/8/25 6:28
 */
public class Bird implements IEatAnimal, IFlyAnimal {

    @Override
    public void eat() {
        System.out.println("吃小米");
    }

    @Override
    public void fly() {
        System.out.println("在海边上飞");
    }


}
