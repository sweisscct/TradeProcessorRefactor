/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tradeprocessorrefactor;

/**
 *
 * @author Lecturer
 */
public class ValidateDataLengthDecerator implements DataValidation {
    private ValidateDataLength validator = new ValidateDataLength();
    
    
    
    @Override
    public boolean validateData(String[] fields) {
        boolean isValid = validator.validateData(fields);
        if (!isValid) System.out.println("Warning: Incorrect number of fields");
        return isValid;
    }
}
