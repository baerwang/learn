package com.baerwang.adapter.logindapter.v2;

/**
 * @author baerwang
 * @since 2020/9/23 21:26
 */
public class PassportTest {

    public static void main(String[] args) {
        IPassportForThird passportForThird = new PassportForThirdAdapter();
        passportForThird.loginForQQ("1");
    }
}
