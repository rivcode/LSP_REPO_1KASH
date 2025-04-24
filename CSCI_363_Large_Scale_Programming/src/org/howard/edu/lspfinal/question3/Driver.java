package org.howard.edu.lspfinal.question3;

/**
 * Driver class to demonstrate the usage of the reporting system.
 * This class shows how to use the Template Method pattern to generate different types of reports.
 */
public class Driver {
    
    /**
     * Main method to run the demonstration.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Create a sales report
        Report salesReport = new SalesReport();
        salesReport.generateReport();
        
        System.out.println(); // Add a blank line for readability
        
        // Create an inventory report
        Report inventoryReport = new InventoryReport();
        inventoryReport.generateReport();
    }
}

/**
 * References:
 * 
 * 1. Java Main Method:
 *    https://docs.oracle.com/javase/tutorial/getStarted/cupojava/
 * 
 * 2. Java Command Line Arguments:
 *    https://docs.oracle.com/javase/tutorial/essential/environment/cmdLineArgs.html
 * 
 * 3. Java Object Creation:
 *    https://docs.oracle.com/javase/tutorial/java/javaOO/objectcreation.html
 * 
 * 4. Java Polymorphism:
 *    https://docs.oracle.com/javase/tutorial/java/IandI/polymorphism.html
 * 
 * 5. Template Method Pattern Usage:
 *    https://refactoring.guru/design-patterns/template-method/java/example
 * 
 * 6. Java System.out.println:
 *    https://docs.oracle.com/javase/8/docs/api/java/lang/System.html#out
 */ 