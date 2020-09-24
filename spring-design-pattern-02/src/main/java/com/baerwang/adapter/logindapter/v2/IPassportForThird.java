package com.baerwang.adapter.logindapter.v2;

import com.baerwang.adapter.logindapter.ResultMsg;

/**
 * @author baerwang
 * @since 2020/9/23 21:19
 */
public interface IPassportForThird {

    ResultMsg loginForQQ(String id);

    ResultMsg loginForWeChat(String id);

    ResultMsg loginForToken(String token);

    ResultMsg loginForTelPhone(String telPhone, String code);

    ResultMsg loginForRegist(String userName, String passport);
}
