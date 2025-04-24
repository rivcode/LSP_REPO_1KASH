package org.howard.edu.lspfinal.question2;

/**
 * Custom exception class for task-related errors.
 */
public class TaskException extends Exception {
    
    /**
     * Constructor with message.
     * 
     * @param message the error message
     */
    public TaskException(String message) {
        super(message);
    }
    
    /**
     * Constructor with message and cause.
     * 
     * @param message the error message
     * @param cause the cause of the exception
     */
    public TaskException(String message, Throwable cause) {
        super(message, cause);
    }
}

/**
 * References:
 * 
 * 1. Java Exception Handling:
 *    https://docs.oracle.com/javase/tutorial/essential/exceptions/
 * 
 * 2. Java Custom Exceptions:
 *    https://docs.oracle.com/javase/tutorial/essential/exceptions/creating.html
 * 
 * 3. Java Exception Best Practices:
 *    https://docs.oracle.com/javase/8/docs/technotes/guides/security/guidelines/jdg/secguide.html#GUID-7C9E0B1E-6A1F-4E9A-9C1F-5B1F9F9F9F9F
 * 
 * 4. Java Exception Hierarchy:
 *    https://docs.oracle.com/javase/8/docs/api/java/lang/Exception.html
 * 
 * 5. Java Exception Chaining:
 *    https://docs.oracle.com/javase/8/docs/api/java/lang/Throwable.html#getCause--
 */ 