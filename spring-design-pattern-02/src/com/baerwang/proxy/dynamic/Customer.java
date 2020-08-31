package com.baerwang.proxy.dynamic;

import com.baerwang.proxy.xx.Person;

/**
 * @author baerwang
 * @since 2020/8/30 11:47
 */
public class Customer implements Person {
    @Override
    public void findLove() {
        System.out.println("帅");
        System.out.println("身高180cm");
        System.out.println("肥肉瘦肉");
    }
}
