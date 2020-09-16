package com.baerwang.proxy.dynamic;

import com.baerwang.proxy.dynamic.proxy.JDKMeiPo;
import com.baerwang.proxy.xx.Person;

/**
 * 动态代理
 *
 * @author baerwang
 * @since 2020/8/30 11:38
 */
public class DynamicTest {

    public static void main(String[] args) throws Exception {
        Person instance = (Person) new JDKMeiPo().getInstance(new Customer());
        instance.findLove();
    }
}
