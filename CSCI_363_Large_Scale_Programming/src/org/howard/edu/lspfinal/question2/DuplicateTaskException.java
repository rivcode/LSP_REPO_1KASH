package org.howard.edu.lspfinal.question2;

/**
 * Custom exception thrown when attempting to add a task with a name that already exists.
 */
public class DuplicateTaskException extends Exception {
    
    /**
     * Constructs a DuplicateTaskException with the specified detail message.
     * 
     * @param message the detail message (which is saved for later retrieval by the getMessage() method)
     */
    public DuplicateTaskException(String message) {
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