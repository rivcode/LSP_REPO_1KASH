package org.howard.edu.lspfinal.question2;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages a collection of tasks.
 */
public class TaskManager {
    private List<Task> tasks;
    
    /**
     * Constructor for TaskManager.
     */
    public TaskManager() {
        this.tasks = new ArrayList<>();
    }
    
    /**
     * Adds a task to the manager.
     * 
     * @param task the task to add
     * @throws TaskException if the task is null
     */
    public void addTask(Task task) throws TaskException {
        if (task == null) {
            throw new TaskException("Cannot add null task");
        }
        tasks.add(task);
    }
    
    /**
     * Removes a task from the manager.
     * 
     * @param taskId the ID of the task to remove
     * @throws TaskException if the task is not found
     */
    public void removeTask(String taskId) throws TaskException {
        Task taskToRemove = findTaskById(taskId);
        if (taskToRemove == null) {
            throw new TaskException("Task not found: " + taskId);
        }
        tasks.remove(taskToRemove);
    }
    
    /**
     * Marks a task as completed.
     * 
     * @param taskId the ID of the task to mark as completed
     * @throws TaskException if the task is not found
     */
    public void markTaskAsCompleted(String taskId) throws TaskException {
        Task task = findTaskById(taskId);
        if (task == null) {
            throw new TaskException("Task not found: " + taskId);
        }
        task.markAsCompleted();
    }
    
    /**
     * Gets all tasks.
     * 
     * @return a list of all tasks
     */
    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks);
    }
    
    /**
     * Gets all completed tasks.
     * 
     * @return a list of completed tasks
     */
    public List<Task> getCompletedTasks() {
        List<Task> completedTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.isCompleted()) {
                completedTasks.add(task);
            }
        }
        return completedTasks;
    }
    
    /**
     * Gets all pending tasks.
     * 
     * @return a list of pending tasks
     */
    public List<Task> getPendingTasks() {
        List<Task> pendingTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (!task.isCompleted()) {
                pendingTasks.add(task);
            }
        }
        return pendingTasks;
    }
    
    /**
     * Finds a task by its ID.
     * 
     * @param taskId the ID of the task to find
     * @return the task if found, null otherwise
     */
    private Task findTaskById(String taskId) {
        for (Task task : tasks) {
            if (task.getId().equals(taskId)) {
                return task;
            }
        }
        return null;
    }
}

/**
 * References:
 * 
 * 1. Java Collections Framework:
 *    https://docs.oracle.com/javase/8/docs/technotes/guides/collections/overview.html
 * 
 * 2. Java ArrayList:
 *    https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
 * 
 * 3. Java List Interface:
 *    https://docs.oracle.com/javase/8/docs/api/java/util/List.html
 * 
 * 4. Java Defensive Copying:
 *    https://docs.oracle.com/javase/8/docs/technotes/guides/security/guidelines/jdg/secguide.html#GUID-7C9E0B1E-6A1F-4E9A-9C1F-5B1F9F9F9F9F
 * 
 * 5. Java Collections Best Practices:
 *    https://docs.oracle.com/javase/8/docs/technotes/guides/collections/designfaq.html
 */ 