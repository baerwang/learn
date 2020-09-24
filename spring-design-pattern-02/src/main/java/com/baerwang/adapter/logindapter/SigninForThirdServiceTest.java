package com.baerwang.adapter.logindapter;

import com.baerwang.adapter.logindapter.v1.service.SigninForThirdService;

/**
 * @author baerwang
 * @since 2020/9/23 14:48
 */
public class SigninForThirdServiceTest {

    public static void main(String[] args) {
        SigninForThirdService service = new SigninForThirdService();
        service.loginForQQ("hello");
    }
}
