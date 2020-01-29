package com.mexservice.mex.coredb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBFactory
{

    private static String CONNECTION_STRING_PATTERN = "jdbc:sqlite:%s";
    private static String DB_NAME = "mex.db";

    public static Connection getConnection() throws SQLException {

        String dbURL = String.format(CONNECTION_STRING_PATTERN, DB_NAME);

        return DriverManager.getConnection(dbURL);

    }
}