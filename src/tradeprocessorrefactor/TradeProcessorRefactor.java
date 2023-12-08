/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tradeprocessorrefactor;
import java.io.IOException;
import tradeprocessorrefactor.TradeProcessor;
/**
 *
 * @author Lecturer
 * 
 * Objective: SOLID design
 * S: Single responsibility
 *      Each class has just one job
 * O: Open/closed principle
 *      Open to extension, closed to modification
 * L: Liskov Subsitution
 *      Every child class should be able to take the place of its parent (ancestor) class.
 *      The child cannot have stronger/stricter input conditions (cannot accept less)
 *      The child cannot have weaker output conditions (cannot output more)
 * I: Interface Segregation
 *      Anything implementing an interface should use (and not just implement) all of the methods
 *      If there is an interface where some implementing classes do not use the methods, it should be split up
 * D: Dependency inversion
 *      High-level code should NOT depend directly on low-level code
 *      ie try to avoid coding specific implementations (ie new) in high-level modules
 *      Trick: Factory pattern
 */
public class TradeProcessorRefactor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        // TODO code application logic here
        TradeProcessor tradeProcessor = new TradeProcessor();
        tradeProcessor.processTrades();
    }
    
}
