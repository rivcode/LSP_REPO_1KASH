package org.howard.edu.lspfinal.question2;

/**
 * Custom exception thrown when attempting to retrieve or update a task that does not exist.
 */
public class TaskNotFoundException extends Exception {
    
    /**
     * Constructs a TaskNotFoundException with the specified detail message.
     * 
     * @param message the detail message (which is saved for later retrieval by the getMessage() method)
     */
    public TaskNotFoundException(String message) {
        super(message);
    }
}

/**
 * References:
 * 
 * 1. Java Exception Handling:
 *    https://docs.oracle.com/javase/tutorial/essential/exceptions/
 * 
 * 2. Creating Custom Exceptions in Java:
 *    https://www.baeldung.com/java-custom-exceptions
 * 
 * 3. Java Exception Class:
 *    https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Exception.html
 */ 