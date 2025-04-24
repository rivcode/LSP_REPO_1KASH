package org.howard.edu.lspfinal.question2;

/**
 * Driver class to demonstrate the functionality of the TaskManager.
 */
public class Driver {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        
        try {
            // Add some tasks
            manager.addTask("Complete Project", 1, "TODO");
            manager.addTask("Review Code", 2, "TODO");
            manager.addTask("Write Tests", 3, "TODO");
            
            // Try to add a duplicate task
            try {
                manager.addTask("Complete Project", 1, "TODO");
            } catch (DuplicateTaskException e) {
                System.out.println("Error: " + e.getMessage());
            }
            
            // Get a task by name
            try {
                Task task = manager.getTaskByName("Review Code");
                System.out.println("Found task: " + task);
            } catch (TaskNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }
            
            // Update a task's status
            manager.updateStatus("Complete Project", "IN_PROGRESS");
            
            // Try to update a nonexistent task
            try {
                manager.updateStatus("Nonexistent Task", "DONE");
            } catch (TaskNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }
            
            // Print all tasks grouped by status
            manager.printTasksGroupedByStatus();
            
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }
}

/**
 * References:
 * 
 * 1. Java Main Method:
 *    https://docs.oracle.com/javase/tutorial/getStarted/cupojava/
 * 
 * 2. Java Try-Catch Blocks:
 *    https://docs.oracle.com/javase/tutorial/essential/exceptions/try.html
 * 
 * 3. Java System.out.println:
 *    https://docs.oracle.com/javase/8/docs/api/java/lang/System.html#out
 * 
 * 4. Java Exception Handling:
 *    https://docs.oracle.com/javase/tutorial/essential/exceptions/
 * 
 * 5. Java Command Line Arguments:
 *    https://docs.oracle.com/javase/tutorial/essential/environment/cmdLineArgs.html
 * 
 * 6. Java Program Structure:
 *    https://docs.oracle.com/javase/tutorial/getStarted/cupojava/win32.html
 */ 