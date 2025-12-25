/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.*;

/**
 *
 * @author SARK-29
 */
public class DBHelper {

    private static Connection connection;

    public static void openConnection() {
        if (connection == null) {
            try {
                String url = "jdbc:h2:./db_file/chatbot_1";
                String user = "sa";
                String password = "";
                Class.forName("org.h2.Driver");
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException | ClassNotFoundException t) {
                System.out.println("Connection Error!");
                t.printStackTrace();
            }
        }
    }

    public static int insertQueryGetId(String query) {
        openConnection();
        int num = 0;
        int result = -1;
        try {
            Statement stmt = connection.createStatement();
            num = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                result = rs.getInt(1);
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
            result = -1;
        }
        return result;
    }

    public static boolean executeQuery(String query) {
        openConnection();
        boolean result = false;
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
            result = true;
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static ResultSet selectQuery(String query) {
        openConnection();
        ResultSet rs = null;
        try {
            Statement stmt = connection.createStatement();
            rs = stmt.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
}
