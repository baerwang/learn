package com.baerwang.adapter.logindapter.v1.service;

import com.baerwang.adapter.logindapter.ResultMsg;

/**
 * @author baerwang
 * @since 2020/9/23 14:35
 */
public class SigninForThirdService extends SiginService {

    public ResultMsg loginForQQ(String openId) {
        //1.openId是全局唯一的，可以把它当作一个用户名(加长)
        //2.密码默认为123455
        //3.注册
        //4.调用登录方法
        return loginForRegist(openId, null);
    }

    public ResultMsg loginForWeChat(String openId) {
        return null;
    }

    public ResultMsg loginForToken(String token) {
        return null;
    }

    public ResultMsg loginForTelPhone(String telPhone, String code) {
        return null;
    }

    public ResultMsg loginForRegist(String userName, String password) {
        super.regist(userName, null);
        return super.login(userName, null);
    }
}
