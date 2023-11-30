/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aadp21nov;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import tradeprocessorrefactor.CSVReader;
import tradeprocessorrefactor.DataInput;
import tradeprocessorrefactor.TradeRecord;
import tradeprocessorrefactor.Validator;

/**
 *
 * @author Sam
 */

public class TradeProcessor {
    /*
    1. Reading all the rows from the csv files
    2. Validating each row
    3. Make a new TradeRecord from the validated and parsed data
    4. Setting up database
    5. Inserting trades into database
    */
    
    public void ProcessTrades()
            throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        // Part 1
        System.out.println("Start");
        DataInput input = new CSVReader();
        List<String> lines = input.getData();

        List<TradeRecord> trades = new ArrayList<>();
        
        // Part 2
//        lines.forEach(line -> {
        for (String line : lines) {
            String[] fields = line.split(",");
            Validator validator = new Validator();
            if (!validator.validateDataInput(fields)) continue;
            
            // Part 3
            String sourceCurrencyCode = fields[0].substring(0, 3);
            String destinationCurrencyCode = fields[0].substring(3, 6);

            TradeRecord trade = new TradeRecord(sourceCurrencyCode, destinationCurrencyCode, tradeAmount, tradePrice);
            trades.add(trade);
//        });
        }

           // Part 4
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        String DB_URL = "jdbc:mysql://localhost/trades";
        String USER = "aadp2023";
        String PASS = "aadp2023";

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
            System.out.println("Created table in given database...");

               // Part 5
            for (TradeRecord trade : trades) {
                sql = String.format(
                        "INSERT INTO trades (sourceCurrencyCode, destinationCurrencyCode, tradeAmount, tradePrice) VALUES ('%s', '%s', %d, %f);",
                        trade.sourceCurrencyCode, trade.destinationCurrencyCode, trade.tradeAmount, trade.tradePrice);
                stmt.executeUpdate(sql);
            }
            System.out.println("Sucessful");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
