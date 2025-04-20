package org.sda.todolist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    Task task;

    String validTitle = "Test Title";
    String validProject = "Test Project";
    LocalDate validDueDate;

    @BeforeEach
    public void setUp() {
        validDueDate = LocalDate.now().plusDays(10); // Always a future date
        task = new Task(validTitle, validProject, validDueDate);
    }

    @Test
    public void testValidTitle() {
        assertEquals(validTitle, task.getTitle());
    }

    @Test
    public void testEmptyTitle() {
        assertThrows(NullPointerException.class, () -> task.setTitle(""));
    }

    @Test
    public void testTrimEmptyTitle() {
        assertThrows(NullPointerException.class, () -> task.setTitle("           "));
    }

    @Test
    public void testNullTitle() {
        assertThrows(NullPointerException.class, () -> task.setTitle(null));
    }

    @Test
    public void testValidProject() {
        assertEquals(validProject, task.getProject());
    }

    @Test
    public void testEmptyProject() {
        task.setProject("");
        assertEquals("", task.getProject());
    }

    @Test
    public void testValidDueDate() {
        assertEquals(validDueDate, task.getDueDate());
    }

    @Test
    public void testIncorrectFormatDueDate() {
        assertThrows(DateTimeParseException.class, () -> {
            LocalDate.parse("2020-31-12"); // invalid format
        });
    }

    @Test
    public void testPastDueDate() {
        LocalDate pastDate = LocalDate.now().minusDays(10);
        assertThrows(DateTimeException.class, () -> task.setDueDate(pastDate));
    }

    @Test
    public void testNullDueDate() {
        assertThrows(NullPointerException.class, () -> task.setDueDate(null));
    }

    @Test
    public void testDuplicateTaskEquality() {
        Task anotherTask = new Task(validTitle, validProject, validDueDate);
        assertEquals(task, anotherTask);
    }

    @Test
    public void testTaskHashCode() {
        Task anotherTask = new Task(validTitle, validProject, validDueDate);
        assertEquals(task.hashCode(), anotherTask.hashCode());
    }
}
