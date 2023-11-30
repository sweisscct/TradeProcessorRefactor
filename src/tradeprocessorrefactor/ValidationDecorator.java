/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tradeprocessorrefactor;

/**
 *
 * @author Lecturer
 */
public class ValidationDecorator implements DataValidation {
    private DataValidation validator;
    private String errorMessage;

    public ValidationDecorator(DataValidation validator, String errorMessage) {
        this.validator = validator;
        this.errorMessage = errorMessage;
    }
    
    @Override
    public boolean validateData(String[] fields) {
        boolean isValid = validator.validateData(fields);
            if (!isValid) System.out.println(errorMessage);
        return isValid;
    }
}
