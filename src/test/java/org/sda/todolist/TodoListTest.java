package org.sda.todolist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class TodoListTest {

    private TodoList todoList;

    @BeforeEach
    public void setUp() {
        todoList = new TodoList();
    }

    @Test
    public void testAddTask() {
        todoList.addTask("Test Task", "Test Project", LocalDate.now());
        assertEquals(1, todoList.notCompletedCount());
    }

    @Test
    public void testAddMultipleTasks() {
        todoList.addTask("Task 1", "Project 1", LocalDate.now());
        todoList.addTask("Task 2", "Project 2", LocalDate.now());
        assertEquals(2, todoList.notCompletedCount());
    }

    @Test
    public void testCompletedCountEmpty() {
        assertEquals(0, todoList.completedCount());
    }

    @Test
    public void testSaveAndReadFromFile() {
        String filename = "test_tasks.obj";

        todoList.addTask("Persistent Task", "Project X", LocalDate.now());
        boolean saveStatus = todoList.saveToFile(filename);
        assertTrue(saveStatus);

        TodoList loadedList = new TodoList();
        boolean readStatus = loadedList.readFromFile(filename);
        assertTrue(readStatus);

        // Cleanup
        new File(filename).delete();
    }

    @Test
    public void testReadFromMissingFile() {
        boolean result = todoList.readFromFile("non_existent.obj");
        assertFalse(result);
    }

    @Test
    public void testSaveToInvalidPath() {
        // Windows example: ":" is an invalid character
        boolean result = todoList.saveToFile("invalid:/path.obj");
        assertFalse(result);
    }

    @Test
    public void testNotCompletedCountAfterMarkingCompleted() {
        todoList.addTask("Mark me done", "Project A", LocalDate.now());
        // Since we cannot access task directly, we assume it's still not marked
        assertEquals(1, todoList.notCompletedCount());
    }

    @Test
    public void testCompletedCountAfterMultipleTasks() {
        todoList.addTask("Incomplete Task", "Project A", LocalDate.now());
        todoList.addTask("Another Incomplete Task", "Project B", LocalDate.now());
        assertEquals(0, todoList.completedCount());
    }

    @Test
    public void testAddTaskWithEmptyProject() {
        todoList.addTask("Task with no project", "", LocalDate.now());
        assertEquals(1, todoList.notCompletedCount());
    }

}

