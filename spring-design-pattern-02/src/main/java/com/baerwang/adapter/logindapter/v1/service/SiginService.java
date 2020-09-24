package com.baerwang.adapter.logindapter.v1.service;

import com.baerwang.adapter.logindapter.ResultMsg;
import com.baerwang.template.entity.Member;

/**
 * @author baerwang
 * @since 2020/9/23 14:32
 */
public class SiginService {

    /**
     * 注册方法
     *
     * @param userName
     * @param password
     * @return
     */
    public ResultMsg regist(String userName, String password) {
        return new ResultMsg(200, "注册成功", new Member());
    }

    /**
     * 登陆方法
     *
     * @param userName
     * @param password
     * @return
     */
    public ResultMsg login(String userName, String password) {
        return null;
    }

}
