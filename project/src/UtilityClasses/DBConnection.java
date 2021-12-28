/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UtilityClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author B.M.D.C.Bandara
 */
public class DBConnection {

    private static Connection con = null;

    public static void con() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String sql = "jdbc:mysql://localhost:3306/inventory_db";
        con = DriverManager.getConnection(sql, "root", "123");
    }

    public static void iud(String sql) throws Exception {
        if (con == null) {
            con();
        }
        con.createStatement().executeUpdate(sql);
    }

    public static ResultSet search(String sql) throws Exception {
        if (con == null) {
            con();
        }
        return con.createStatement().executeQuery(sql);
    }

    public static Connection getConnection() throws Exception {
        if (con == null) {
            con();
        }
        return con;
    }
}
