package com.baerwang.adapter.logindapter.v2.adapters;

import com.baerwang.adapter.logindapter.ResultMsg;

/**
 * @author baerwang
 * @since 2020/9/23 21:18
 */
public class LoginForWeChatAdapter implements LoginAdapter {

    @Override
    public boolean support(Object adapter) {
        return adapter instanceof LoginForWeChatAdapter;
    }

    @Override
    public ResultMsg login(String id, Object adapter) {
        return null;
    }
}
