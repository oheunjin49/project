package com.example.faq;

import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTest {

    public static void main(String[] args) {
        String driver = "net.sf.log4jdbc.sql.jdbcapi.DriverSpy";
        String url = "jdbc:log4jdbc:oracle:thin:@mingu_medium?TNS_ADMIN=C:/Users/ds/Downloads/Wallet-mingu";
        String user = "admin";
        String password = "40028rnalsE3";
        try {
            Class.forName(driver);
            System.out.println("jdbc driver success");
            DriverManager.getConnection(url, user, password);
            System.out.println("Oracle Done");
        } catch (ClassNotFoundException e) {
            System.out.println("jdbc driver failure");
        } catch (SQLException e) {
            System.out.println("Oracle Failure");
        }
    }
}
