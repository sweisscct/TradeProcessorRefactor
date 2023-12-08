/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package tradeprocessorrefactor;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lecturer
 */
public class TradeParserTest {
    
    public TradeParserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of parseInputData method, of class TradeParser.
     * {EURUSD,10,12.5, EURUSD,10,12.5, EURUSD,10,12.5}
     * {EURUSD,10,12.5, GBPEUR,100000,12, EURUSD,10,12.5}
     * {EURUSDS,10,12.5}
     * {EURUSD,10.0,12.5}
     * {EURUSD,10,-12.5}
     * 
     */
    @Test
    public void testParseInputData() {
        System.out.println("parseInputData");
        List<String> inputs = new ArrayList<>();
        inputs.add("EURUSD,10,12.5");
        inputs.add("EURUSD,10,12.5");
        inputs.add("EURUSD,10,12.5");
        TradeParser instance = new TradeParser(inputs);
        TradeRecord trade1 = new TradeRecord("EUR", "USD", 10, 12.5);
        TradeRecord trade2 = new TradeRecord("EUR", "USD", 10, 12.5);
        TradeRecord trade3 = new TradeRecord("EUR", "USD", 10, 12.5);
        ArrayList<TradeRecord> expResult = new ArrayList<>();
        expResult.add(trade1);
        expResult.add(trade2);
        expResult.add(trade3);
        ArrayList<TradeRecord> result = instance.parseInputData();
//        assertEquals(expResult, result);
        assertEquals(expResult.size(), result.size());
        for (int tradeNum = 0; tradeNum < expResult.size(); tradeNum++) {
            assertEquals(expResult.get(tradeNum).getDestinationCurrencyCode(), result.get(tradeNum).getDestinationCurrencyCode());
            assertEquals(expResult.get(tradeNum).getSourceCurrencyCode(), result.get(tradeNum).getSourceCurrencyCode());
            assertEquals(expResult.get(tradeNum).getTradeAmount(), result.get(tradeNum).getTradeAmount());
            assertEquals(expResult.get(tradeNum).getTradePrice(), result.get(tradeNum).getTradePrice(), .001);
        }
        // Second Test
        inputs.clear();
        expResult.clear();
        inputs.add("EURUSD,10,12.5");
        inputs.add("GBPEUR,100000,12");
        inputs.add("EURUSD,10,12.5");
        TradeParser instance2 = new TradeParser(inputs);
        trade1 = new TradeRecord("EUR", "USD", 10, 12.5);
        trade2 = new TradeRecord("GBP", "EUR", 100000, 12);
        trade3 = new TradeRecord("EUR", "USD", 10, 12.5);  
        expResult.add(trade1);
        expResult.add(trade2);
        expResult.add(trade3);
        result = instance2.parseInputData();
        assertEquals(expResult.size(), result.size());
        for (int tradeNum = 0; tradeNum < expResult.size(); tradeNum++) {
            assertEquals(expResult.get(tradeNum).getDestinationCurrencyCode(), result.get(tradeNum).getDestinationCurrencyCode());
            assertEquals(expResult.get(tradeNum).getSourceCurrencyCode(), result.get(tradeNum).getSourceCurrencyCode());
            assertEquals(expResult.get(tradeNum).getTradeAmount(), result.get(tradeNum).getTradeAmount());
            assertEquals(expResult.get(tradeNum).getTradePrice(), result.get(tradeNum).getTradePrice(), .001);
        }    
        
        // Test 3
        inputs.clear();
        expResult.clear();
        inputs.add("EURUSD,10,12.5");
        inputs.add("GBPEUR,100000,12");
        inputs.add("EURUSDS,10,12.5");
        TradeParser instance3 = new TradeParser(inputs);
        trade1 = new TradeRecord("EUR", "USD", 10, 12.5);
        trade2 = new TradeRecord("GBP", "EUR", 100000, 12);
//        trade3 = new TradeRecord("EUR", "USD", 10, 12.5);  
        expResult.add(trade1);
        expResult.add(trade2);
//        expResult.add(trade3);
        result = instance3.parseInputData();
        assertEquals(expResult.size(), result.size());
        for (int tradeNum = 0; tradeNum < expResult.size(); tradeNum++) {
            assertEquals(expResult.get(tradeNum).getDestinationCurrencyCode(), result.get(tradeNum).getDestinationCurrencyCode());
            assertEquals(expResult.get(tradeNum).getSourceCurrencyCode(), result.get(tradeNum).getSourceCurrencyCode());
            assertEquals(expResult.get(tradeNum).getTradeAmount(), result.get(tradeNum).getTradeAmount());
            assertEquals(expResult.get(tradeNum).getTradePrice(), result.get(tradeNum).getTradePrice(), .001);
        } 
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
