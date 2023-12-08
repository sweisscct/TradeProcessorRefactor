/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tradeprocessorrefactor;

/**
 *
 * @author Lecturer
 */
public class DataOutputFactory {
    public DataOutput makeDataOutput(DataIOTypes type) {
        switch (type) {
            case DATABASE : return new DatabaseOutput();
            default : return null;
        }
    }
}
