/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tradeprocessorrefactor;

/**
 *
 * @author Lecturer
 */
public class DataInputFactory {
    public DataInput makeDataInput(DataInputTypes inputType) {
        switch (inputType) {
            case CSV : return new CSVReader();
            default: return null;
        }
    }
}
