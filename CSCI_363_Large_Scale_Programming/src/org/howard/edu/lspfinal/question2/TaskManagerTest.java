package org.howard.edu.lspfinal.question2;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

/**
 * Test class for TaskManager.
 */
public class TaskManagerTest {
    private TaskManager taskManager;
    private Task task1;
    private Task task2;
    
    @Before
    public void setUp() {
        taskManager = new TaskManager();
        task1 = new Task("TASK-001", "Complete project documentation");
        task2 = new Task("TASK-002", "Review code");
    }
    
    @Test
    public void testAddTask() throws TaskException {
        taskManager.addTask(task1);
        List<Task> tasks = taskManager.getAllTasks();
        assertEquals(1, tasks.size());
        assertEquals(task1, tasks.get(0));
    }
    
    @Test(expected = TaskException.class)
    public void testAddNullTask() throws TaskException {
        taskManager.addTask(null);
    }
    
    @Test
    public void testRemoveTask() throws TaskException {
        taskManager.addTask(task1);
        taskManager.removeTask(task1.getId());
        assertEquals(0, taskManager.getAllTasks().size());
    }
    
    @Test(expected = TaskException.class)
    public void testRemoveNonExistentTask() throws TaskException {
        taskManager.removeTask("NON-EXISTENT");
    }
    
    @Test
    public void testMarkTaskAsCompleted() throws TaskException {
        taskManager.addTask(task1);
        taskManager.markTaskAsCompleted(task1.getId());
        assertTrue(task1.isCompleted());
    }
    
    @Test(expected = TaskException.class)
    public void testMarkNonExistentTaskAsCompleted() throws TaskException {
        taskManager.markTaskAsCompleted("NON-EXISTENT");
    }
    
    @Test
    public void testGetCompletedTasks() throws TaskException {
        taskManager.addTask(task1);
        taskManager.addTask(task2);
        taskManager.markTaskAsCompleted(task1.getId());
        
        List<Task> completedTasks = taskManager.getCompletedTasks();
        assertEquals(1, completedTasks.size());
        assertEquals(task1, completedTasks.get(0));
    }
    
    @Test
    public void testGetPendingTasks() throws TaskException {
        taskManager.addTask(task1);
        taskManager.addTask(task2);
        taskManager.markTaskAsCompleted(task1.getId());
        
        List<Task> pendingTasks = taskManager.getPendingTasks();
        assertEquals(1, pendingTasks.size());
        assertEquals(task2, pendingTasks.get(0));
    }
}

/**
 * References:
 * 
 * 1. JUnit 4 Documentation:
 *    https://junit.org/junit4/
 * 
 * 2. JUnit Assertions:
 *    https://junit.org/junit4/javadoc/4.13/org/junit/Assert.html
 * 
 * 3. JUnit Test Annotations:
 *    https://junit.org/junit4/javadoc/4.13/org/junit/Test.html
 * 
 * 4. JUnit Expected Exceptions:
 *    https://junit.org/junit4/javadoc/4.13/org/junit/Test.html#expected()
 * 
 * 5. JUnit Best Practices:
 *    https://junit.org/junit4/wiki/CodeExamples
 */ 