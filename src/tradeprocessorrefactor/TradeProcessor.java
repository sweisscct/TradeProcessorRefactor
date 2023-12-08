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
import tradeprocessorrefactor.Database;
import tradeprocessorrefactor.TradeParser;
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
        
        // Part 2
        // Part 3
        TradeParser tradeParser = new TradeParser(lines);
        // Validates before parsing
        List<TradeRecord> trades = tradeParser.parseInputData();

            
           // Part 4
        boolean dbTableReady = Database.setupDatabase();
        if (dbTableReady) {
            
        }

               // Part 5

            }
            System.out.println("Sucessful");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
