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

/**
 *
 * @author Sam
 */
public class TradeProcessor {
    public void ProcessTrades()
            throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        System.out.println("Start");
        BufferedReader myReader = new BufferedReader(new FileReader("trades.csv"));
        List<String> lines = new ArrayList<>();
        String inputLine = myReader.readLine();
        while ((inputLine = myReader.readLine()) != null) {
            lines.add(inputLine);
        }

        List<TradeRecord> trades = new ArrayList<>();

        lines.forEach(line -> {
            String[] fields = line.split(",");
            if (fields.length != 3) {
                System.out.println("Warning: Incorrect number of fields");
            }

            if (fields[0].length() != 6) {
                System.out.println("Warning: Trade currencies malformed");
            }

            int tradeAmount = -1;
            try {
                tradeAmount = Integer.parseInt(fields[1]);
            } catch (Exception e) {
                System.out.println("Warning: Trade amount not a valid integer");
            }

            double tradePrice = -1;
            try {
                tradePrice = Double.parseDouble(fields[2]);
            } catch (Exception e) {
                System.out.println("Warning: Trade price not a valid decimal");
            }

            String sourceCurrencyCode = fields[0].substring(0, 3);
            String destinationCurrencyCode = fields[0].substring(3, 6);

            TradeRecord trade = new TradeRecord(sourceCurrencyCode, destinationCurrencyCode, tradeAmount, tradePrice);
            trades.add(trade);
        });

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

public class TradeRecord {
    String sourceCurrencyCode;
    String destinationCurrencyCode;
    int tradeAmount;
    double tradePrice;

    public TradeRecord(String sourceCurrencyCode, String destinationCurrencyCode, int tradeAmount, double tradePrice) {
        this.sourceCurrencyCode = sourceCurrencyCode;
        this.destinationCurrencyCode = destinationCurrencyCode;
        this.tradeAmount = tradeAmount;
        this.tradePrice = tradePrice;
    }
}
