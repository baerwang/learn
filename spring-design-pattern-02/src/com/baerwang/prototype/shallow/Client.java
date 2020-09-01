package com.baerwang.prototype.shallow;

/**
 * @author baerwang
 * @since 2020/8/29 8:37
 */
public class Client {

    private Prototype prototype;

    public Client(Prototype prototype) {
        this.prototype = prototype;
    }

    public Prototype startClone(Prototype concretePrototype) {
        return (Prototype) concretePrototype.clone();
    }

}
