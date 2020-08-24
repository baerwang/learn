package com.baerwang.isp;

/**
 * @author baerwang
 * @since 2020/8/25 6:28
 */
public class Dog implements IEatAnimal, ISwimAnimal {

    @Override
    public void eat() {
        System.out.println("吃大骨头");
    }

    @Override
    public void swim() {
        System.out.println("去海边游泳");
    }
}
