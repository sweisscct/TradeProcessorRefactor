/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tradeprocessorrefactor;

import java.util.ArrayList;

/**
 *
 * @author Lecturer
 */
public class Validator implements DataValidation {
    // components are the validators!
    // This is a composite pattern
    ArrayList<DataValidation> components = new ArrayList<>();
    public void addComponent(DataValidation validator) {
        components.add(validator);
    }
    
    @Override
    public boolean validateData(String[] fields) {
        boolean isValid = true;
        for (DataValidation component : components) {
            isValid = isValid && component.validateData(fields);
        }
        return isValid;
    }
    
    public boolean validateDataInput(String[] fields) {
        addComponent(new ValidationDecorator(new ValidateDataLength(), "Warning: Incorrect number of fields"));
        addComponent(new ValidationDecorator(new ValidateTradeCurrencyLength(), "Warning: Trade currencies malformed"));
        addComponent(new ValidationDecorator(new TradeAmountValidator(), "Warning: Trade amount not a valid integer"));
        addComponent(new ValidationDecorator(new TradePriceValidator(), "Warning: Trade price not a valid decimal"));
        
        boolean isValid = validateData(fields);
        components.clear();
        return isValid;
        
    }
   
}
