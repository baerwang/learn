package com.baerwang.carp;

/**
 * @author baerwang
 * @since 2020/8/26 6:38
 */
public class MySqlConnection extends DBConnection {

    @Override
    public String getConnection() {
        return "MySql数据库连接";
    }
}
