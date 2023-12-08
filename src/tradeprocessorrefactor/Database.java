/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tradeprocessorrefactor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lecturer
 */
public abstract class Database {
//        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        protected final static String DB_URL = "jdbc:mysql://localhost/trades";
        protected final static String USER = "aadp2023";
        protected final static String PASS = "aadp2023";
        
        public static boolean setupDatabase() {
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();) {
            String sql;
            sql = "CREATE TABLE IF NOT EXISTS trades " +
                    "(id INTEGER not NULL AUTO_INCREMENT, " +
                    " sourceCurrencyCode VARCHAR(255), " +
                    " destinationCurrencyCode VARCHAR(255), " +
                    " tradeAmount INTEGER, " +
                    " tradePrice DOUBLE, " +
                    " PRIMARY KEY ( id ));";
            stmt.executeUpdate(sql);
            System.out.println("Table setup completed sucessfully in given database...");
            return true;
        }   catch (SQLException ex) {
                System.out.println("Problem with setting up table:");
                ex.printStackTrace();
                return false;
            }
        }
}
