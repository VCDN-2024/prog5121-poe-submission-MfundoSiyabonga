import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TaskTest {

    private Task task;

    @Before
    public void setUp() {
        task = new Task("CodeReview", "Review the code for errors and improvements", "JohnDoe", 5);
    }

    @Test
    public void testConstructor() {
        assertEquals("CodeReview", task.getTaskName());
        assertEquals("Review the code for errors and improvements", task.getTaskDescription());
        assertEquals("JohnDoe", task.getDeveloperDetails());
        assertEquals(5, task.getTaskDuration());
        assertEquals("To Do", task.getTaskStatus());
    }

    @Test
    public void testSetTaskStatus() {
        task.setTaskStatus("In Progress");
        assertEquals("In Progress", task.getTaskStatus());
    }

    @Test
    public void testCreateTaskID() {
        String expectedTaskID = "CoJo5";
        assertEquals(expectedTaskID, task.createTaskID());
    }

    @Test
    public void testReturnTotalHours() {
        assertEquals(5, task.returnTotalHours());
    }

    @Test
    public void testPrintTaskDetails() {
        String expectedDetails = "Task Name: CodeReview\n" +
                                 "Task Description: Review the code for errors and improvements\n" +
                                 "Developer Details: JohnDoe\n" +
                                 "Task Duration: 5 hours\n" +
                                 "Task Status: To Do\n" +
                                 "Task ID: CoJo5";
        assertEquals(expectedDetails, task.printTaskDetails());
    }
}

