package com.baerwang.singleton.lazy;

/**
 * @author baerwang
 * @since 2020/8/28
 */
public class LazySimpleSingletonTest {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new ExectorThread());
        Thread thread2 = new Thread(new ExectorThread());
        thread1.start();
        thread2.start();
    }
}
