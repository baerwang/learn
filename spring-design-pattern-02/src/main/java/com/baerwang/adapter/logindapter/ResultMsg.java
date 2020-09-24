package com.baerwang.adapter.logindapter;

/**
 * @author baerwang
 * @since 2020/9/23 14:31
 */
public class ResultMsg {

    private int code;

    private String mst;

    private Object data;

    public ResultMsg(int code, String mst, Object data) {
        this.code = code;
        this.mst = mst;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMst() {
        return mst;
    }

    public void setMst(String mst) {
        this.mst = mst;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
