/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tradeprocessorrefactor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lecturer
 */
public interface DataOutput {
    public void saveData(ArrayList<TradeRecord> trades) throws IOException;
}
