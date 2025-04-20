//package org.sda.todolist;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class MessagesTest {
//
//    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//    private final PrintStream originalOut = System.out;
//
//    @BeforeEach
//    public void setUp() {
//        System.setOut(new PrintStream(outputStream));
//    }
//
//    @AfterEach
//    public void tearDown() {
//        System.setOut(originalOut);
//    }
//
//    @Test
//    public void testShowMessageWarning() {
//        Messages.showMessage("This is a warning", true);
//        String output = outputStream.toString();
//        assertTrue(output.contains(">>> This is a warning"));
//        assertTrue(output.contains(Messages.RED_TEXT));
//    }
//
//    @Test
//    public void testShowMessageInfo() {
//        Messages.showMessage("This is info", false);
//        String output = outputStream.toString();
//        assertTrue(output.contains(">>> This is info"));
//        assertTrue(output.contains(Messages.GREEN_TEXT));
//    }
//
//    @Test
//    public void testSeparator() {
//        Messages.separator('-', 5);
//        String output = outputStream.toString().trim();
//        assertTrue(output.equals("-----"));
//    }
//
//    @Test
//    public void testMainMenu() {
//        Messages.mainMenu(3, 5);
//        String output = outputStream.toString();
//        assertTrue(output.contains("MAIN MENU"));
//        assertTrue(output.contains("3 task(s) todo"));
//        assertTrue(output.contains("5 completed task(s)"));
//    }
//
//    @Test
//    public void testListAllTasksMenu() {
//        Messages.listAllTasksMenu();
//        String output = outputStream.toString();
//        assertTrue(output.contains("Display All Tasks"));
//        assertTrue(output.contains("Show Task List by date"));
//    }
//
//    @Test
//    public void testEditTaskSelection() {
//        Messages.editTaskSelection();
//        String output = outputStream.toString();
//        assertTrue(output.contains(">>> Type a task number to EDIT"));
//    }
//
//    @Test
//    public void testEditTaskMenu() {
//        Messages.editTaskMenu();
//        String output = outputStream.toString();
//        assertTrue(output.contains("Task Edit Options"));
//        assertTrue(output.contains("Modify selected task"));
//    }
//
//    @Test
//    public void testByeMessage() {
//        Messages.byeMessage();
//        String output = outputStream.toString();
//        assertTrue(output.contains(">>> Good Bye"));
//    }
//
//    @Test
//    public void testUnknownMessage() {
//        Messages.unknownMessage();
//        String output = outputStream.toString();
//        assertTrue(output.contains(">>> Incorrect choice"));
//    }
//}
