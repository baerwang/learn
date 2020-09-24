package com.baerwang.adapter.logindapter.v2;

import com.baerwang.adapter.logindapter.ResultMsg;
import com.baerwang.adapter.logindapter.v1.service.SiginService;
import com.baerwang.adapter.logindapter.v2.adapters.*;

/**
 * @author baerwang
 * @since 2020/9/23 21:21
 */
public class PassportForThirdAdapter extends SiginService implements IPassportForThird {

    @Override
    public ResultMsg loginForQQ(String id) {
        return processLogin(id, LoginForQQAdapter.class);
    }

    @Override
    public ResultMsg loginForWeChat(String id) {
        return processLogin(id, LoginForWeChatAdapter.class);
    }

    @Override
    public ResultMsg loginForToken(String token) {
        return processLogin(token, LoginForTokenAdapter.class);
    }

    @Override
    public ResultMsg loginForTelPhone(String telPhone, String code) {
        return processLogin(telPhone, LoginForTelAdapter.class);
    }

    @Override
    public ResultMsg loginForRegist(String userName, String passport) {
        super.regist(userName, null);
        return super.login(userName, null);
    }

    private ResultMsg processLogin(String key, Class<? extends LoginAdapter> clazz) {
        try {
            LoginAdapter adapter = clazz.newInstance();
            if (adapter.support(adapter)) {
                return adapter.login(key, adapter);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
