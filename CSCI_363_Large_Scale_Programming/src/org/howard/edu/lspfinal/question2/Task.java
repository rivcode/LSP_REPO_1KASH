package org.howard.edu.lspfinal.question2;

/**
 * Represents a task in the task management system.
 */
public class Task {
    private String id;
    private String description;
    private boolean completed;
    
    /**
     * Constructor for Task.
     * 
     * @param id the task ID
     * @param description the task description
     */
    public Task(String id, String description) {
        this.id = id;
        this.description = description;
        this.completed = false;
    }
    
    /**
     * Gets the task ID.
     * 
     * @return the task ID
     */
    public String getId() {
        return id;
    }
    
    /**
     * Gets the task description.
     * 
     * @return the task description
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * Checks if the task is completed.
     * 
     * @return true if the task is completed, false otherwise
     */
    public boolean isCompleted() {
        return completed;
    }
    
    /**
     * Marks the task as completed.
     */
    public void markAsCompleted() {
        this.completed = true;
    }
    
    /**
     * Marks the task as not completed.
     */
    public void markAsNotCompleted() {
        this.completed = false;
    }
    
    /**
     * Returns a string representation of the task.
     * 
     * @return a string representation of the task
     */
    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", completed=" + completed +
                '}';
    }
}

/**
 * References:
 * 
 * 1. Java Object Class:
 *    https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html
 * 
 * 2. Java toString() Method:
 *    https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html#toString--
 * 
 * 3. Java Encapsulation:
 *    https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html
 * 
 * 4. Java Immutable Objects:
 *    https://docs.oracle.com/javase/tutorial/essential/concurrency/immutable.html
 * 
 * 5. Java Object-Oriented Programming:
 *    https://docs.oracle.com/javase/tutorial/java/concepts/
 */ 