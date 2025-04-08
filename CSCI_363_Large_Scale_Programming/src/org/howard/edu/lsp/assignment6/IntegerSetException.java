package org.howard.edu.lsp.assignment6;

/**
 * Custom exception class for IntegerSet operations.
 */
public class IntegerSetException extends Exception {

    /**
     * Default serial version UID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new IntegerSetException with no detail message.
     */
    public IntegerSetException() {
        super();
    }

    /**
     * Constructs a new IntegerSetException with the specified detail message.
     *
     * @param message the detail message.
     */
    public IntegerSetException(String message) {
        super(message);
    }
} 