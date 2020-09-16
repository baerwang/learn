package com.baerwang.singleton.threadlocal;

import com.baerwang.singleton.lazy.ExectorThread;

/**
 * 线程单例实现ThreadLocal
 * <p>
 * ThreadLocal 不能保证其创建的对象是全局唯一的，但是能保证在单个线程中是唯一的，天生是线程安全的。
 * 在主线程中无论调用多少次，获取到的实例都是同一个，都在两个子线程中分别获取到了不同的实例。
 * 单例模式为了达到线程安全的目的，会给方法上锁，以时间换空间。
 * ThreadLocal 将所有的对象全部放在ThreadLocalMap中，为每个线程都提供一个对象，实际上是以空间换时间来实现线程隔离的。
 * </p>
 *
 * @author baerwang
 * @since 2020/9/1 10:42
 */
public class ThreadLocalSingletonTest {

    public static void main(String[] args) {
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());

        Thread thread = new Thread(new ExectorThread());
        Thread thread1 = new Thread(new ExectorThread());
        thread.start();
        thread1.start();
        System.out.println("end");
    }

}
