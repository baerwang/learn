package com.baerwang.adapter.logindapter.v2.adapters;

import com.baerwang.adapter.logindapter.ResultMsg;

/**
 * @author baerwang
 * @since 2020/9/23 15:12
 */
public class LoginForSinaAdapter implements LoginAdapter {

    @Override
    public boolean support(Object adapter) {
        return adapter instanceof LoginForSinaAdapter;
    }

    @Override
    public ResultMsg login(String id, Object adapter) {
        return null;
    }
}
