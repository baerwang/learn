package com.baerwang.singleton.register;

/**
 * @author baerwang
 * @since 2020/8/31 16:45
 */
public enum EnumSingleton {

    INSTANCE;

    private Object data;

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static EnumSingleton getInstance() {
        return INSTANCE;
    }

}
