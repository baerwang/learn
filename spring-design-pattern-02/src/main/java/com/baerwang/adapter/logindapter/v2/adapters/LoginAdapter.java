package com.baerwang.adapter.logindapter.v2.adapters;

import com.baerwang.adapter.logindapter.ResultMsg;

/**
 * @author baerwang
 * @since 2020/9/23 14:50
 */
public interface LoginAdapter {

    boolean support(Object adapter);

    ResultMsg login(String id, Object adapter);
}
