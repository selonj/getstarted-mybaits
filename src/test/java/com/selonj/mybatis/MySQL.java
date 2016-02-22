package com.selonj.mybatis;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

/**
 * Created by L.x on 16-2-22.
 */
public class MySQL {
    private static final String DATABASE_NAME = "test";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static MysqlDataSource dataSource() {
        MysqlDataSource mysql = new MysqlDataSource();
        mysql.setDatabaseName(DATABASE_NAME);
        mysql.setUser(USER);
        mysql.setPassword(PASSWORD);
        return mysql;
    }
}
