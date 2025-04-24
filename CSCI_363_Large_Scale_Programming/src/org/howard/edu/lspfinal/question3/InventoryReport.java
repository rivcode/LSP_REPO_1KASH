package org.howard.edu.lspfinal.question3;

/**
 * Concrete implementation of an Inventory Report.
 * This class implements the abstract methods defined in the Report class.
 */
public class InventoryReport extends Report {
    
    /**
     * Loads inventory data from a data source.
     * In a real implementation, this would connect to a database or file.
     */
    @Override
    protected void loadData() {
        System.out.println("Loading inventory data...");
        // In a real implementation, this would load actual inventory data
    }
    
    /**
     * Formats the inventory data for reporting.
     * In a real implementation, this would process the data into a report format.
     */
    @Override
    protected void formatData() {
        System.out.println("Formatting inventory data...");
        // In a real implementation, this would format the data
    }
    
    /**
     * Prints the inventory report.
     * In a real implementation, this would output the formatted report.
     */
    @Override
    protected void printReport() {
        System.out.println("Printing inventory report.");
        // In a real implementation, this would print the report
    }
}

/**
 * References:
 * 
 * 1. Java Inheritance:
 *    https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html
 * 
 * 2. Java Method Overriding:
 *    https://docs.oracle.com/javase/tutorial/java/IandI/override.html
 * 
 * 3. Java Access Modifiers:
 *    https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html
 * 
 * 4. Java Annotations:
 *    https://docs.oracle.com/javase/tutorial/java/annotations/
 * 
 * 5. Java System.out.println:
 *    https://docs.oracle.com/javase/8/docs/api/java/lang/System.html#out
 * 
 * 6. Template Method Pattern Implementation:
 *    https://www.baeldung.com/java-template-method-pattern
 * 
 * 7. Java Concrete Classes:
 *    https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html#abstract-classes
 */ 