/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tradeprocessorrefactor;

/**
 *
 * @author Lecturer
 */
public class ValidateDataLength implements DataValidation{

    @Override
    public boolean validateData(String[] fields) {
        return fields.length == 3;
    }
    
}
