/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tradeprocessorrefactor;

/**
 *
 * @author Lecturer
 */
public class TradePriceValidator implements DataValidation {
    @Override
    public boolean validateData(String[] fields) {
        boolean isValid = true;
        try{
            double tradePrice = Double.parseDouble(fields[2]);
        } catch (Exception e) {
            isValid = false;
        }
        return isValid;
    }
}
