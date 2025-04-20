package org.sda.todolist;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.io.*;

class MessagesTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private PrintStream originalOut;

    @BeforeEach
    void setUp() {
        originalOut = System.out;
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void testMainMenuOutput() {
        int incompleteTasks = 3;
        int completedTasks = 2;

        Messages.mainMenu(incompleteTasks, completedTasks);

        String output = outputStreamCaptor.toString().toLowerCase().trim();


        assertTrue(output.contains("main menu"),
                "Output should contain the main menu header");
        assertTrue(output.contains("3") && output.contains("2"),
                "Output should show correct task counts");
    }
}
