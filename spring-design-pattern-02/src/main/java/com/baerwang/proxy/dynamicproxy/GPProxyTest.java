package com.baerwang.proxy.dynamicproxy;

import com.baerwang.proxy.dynamic.Customer;
import com.baerwang.proxy.xx.Person;

/**
 * @author baerwang
 * @since 2020/9/2 17:31
 */
public class GPProxyTest {

    public static void main(String[] args) {
        try {
            Person person = (Person) new GPMeipo().getInstance(new Customer());
            person.findLove();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
