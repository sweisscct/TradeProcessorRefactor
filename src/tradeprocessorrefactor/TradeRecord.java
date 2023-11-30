/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tradeprocessorrefactor;

/**
 *
 * @author Lecturer
 */
public class TradeRecord {
    private String sourceCurrencyCode;
    private String destinationCurrencyCode;
    private int tradeAmount;
    private double tradePrice;

    public TradeRecord(String sourceCurrencyCode, String destinationCurrencyCode, int tradeAmount, double tradePrice) {
        this.sourceCurrencyCode = sourceCurrencyCode;
        this.destinationCurrencyCode = destinationCurrencyCode;
        this.tradeAmount = tradeAmount;
        this.tradePrice = tradePrice;
    }

    public String getDestinationCurrencyCode() {
        return destinationCurrencyCode;
    }

    public int getTradeAmount() {
        return tradeAmount;
    }

    public double getTradePrice() {
        return tradePrice;
    }

    public String getSourceCurrencyCode() {
        return sourceCurrencyCode;
    }
}
