package com.baerwang.singleton.serializable;

import java.io.Serializable;

/**
 * 序列化单例
 *
 * @author baerwang
 * @since 2020/8/31
 */
public class SerializableSingleton implements Serializable {

    private final static SerializableSingleton SINGLETON = new SerializableSingleton();

    private SerializableSingleton() {
    }

    public static SerializableSingleton getInstance() {
        return SINGLETON;
    }

    /**
     * 反序列化的对象和手动创建的对象是不一致的，实例化了两次，违背了单例模式的设计
     * 再序列化情况下保证单例模式，增加一个方法readResolve()即可
     * 增加了readResolve()方法返回实例解决了单例模式被破坏的问题，但是实际上实例化了两次，
     * 只不过新创建的对象没有被返回而已。
     * 如果创建对象的动作发生频率快，就意味着内存分配开销也会随之增大。
     *
     * @return
     */
    private Object readResolve() {
        return SINGLETON;
    }
}
