/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tradeprocessorrefactor;

/**
 *
 * @author Lecturer
 */
public class TradeAmountValidator implements DataValidation {
    @Override
    public boolean validateData(String[] fields) {
        boolean isValid = true;
        try{
            int tradeAmount = Integer.parseInt(fields[1]);
        } catch (Exception e) {
            isValid = false;
        }
        return isValid;
    }
}
