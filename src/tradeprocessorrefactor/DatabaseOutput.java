/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tradeprocessorrefactor;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static tradeprocessorrefactor.Database.DB_URL;
import static tradeprocessorrefactor.Database.PASS;
import static tradeprocessorrefactor.Database.USER;

/**
 *
 * @author Lecturer
 */
public class DatabaseOutput extends Database implements DataOutput {
    @Override
    public void saveData(ArrayList<TradeRecord> trades) throws IOException {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement stmt = conn.createStatement();) {
            String sql;
            for (TradeRecord trade : trades) {
                sql = String.format(
                        "INSERT INTO trades (sourceCurrencyCode, destinationCurrencyCode, tradeAmount, tradePrice) VALUES ('%s', '%s', %d, %f);",
                        trade.getSourceCurrencyCode(), trade.getDestinationCurrencyCode(), trade.getTradeAmount(), trade.getTradePrice());
                stmt.executeUpdate(sql);
            }
        } catch (SQLException ex) {
            System.out.println("Problem with saving trades: ");
            ex.printStackTrace();
        }
    }     
}
