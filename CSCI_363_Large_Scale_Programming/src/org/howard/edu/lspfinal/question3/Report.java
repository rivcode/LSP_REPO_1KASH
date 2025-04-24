package org.howard.edu.lspfinal.question3;

/**
 * Abstract base class for reports using the Template Method pattern.
 * This class defines the skeleton of the report generation algorithm,
 * deferring some steps to subclasses.
 */
public abstract class Report {
    
    /**
     * Template method that defines the report generation workflow.
     * This method cannot be overridden by subclasses.
     */
    public final void generateReport() {
        loadData();
        formatData();
        printReport();
    }
    
    /**
     * Abstract method for loading data.
     * Must be implemented by concrete report classes.
     */
    protected abstract void loadData();
    
    /**
     * Abstract method for formatting data.
     * Must be implemented by concrete report classes.
     */
    protected abstract void formatData();
    
    /**
     * Abstract method for printing the report.
     * Must be implemented by concrete report classes.
     */
    protected abstract void printReport();
}

/**
 * References:
 * 
 * 1. Template Method Pattern:
 *    https://en.wikipedia.org/wiki/Template_method_pattern
 * 
 * 2. Java Abstract Classes:
 *    https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html
 * 
 * 3. Java Final Keyword:
 *    https://docs.oracle.com/javase/tutorial/java/IandI/final.html
 * 
 * 4. Java Method Overriding:
 *    https://docs.oracle.com/javase/tutorial/java/IandI/override.html
 * 
 * 5. Design Patterns in Java:
 *    https://www.oodesign.com/
 * 
 * 6. Java Access Modifiers:
 *    https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html
 * 
 * 7. Java Method Invocation:
 *    https://docs.oracle.com/javase/tutorial/java/javaOO/methods.html
 */ 