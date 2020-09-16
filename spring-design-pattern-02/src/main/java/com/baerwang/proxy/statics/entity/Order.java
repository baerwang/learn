package com.baerwang.proxy.statics.entity;

/**
 * @author baerwang
 * @since 2020/8/30 6:20
 */
public class Order {

    private String id;

    private Long createTime;

    private Object orderInfo;


    public Object getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(Object orderInfo) {
        this.orderInfo = orderInfo;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
