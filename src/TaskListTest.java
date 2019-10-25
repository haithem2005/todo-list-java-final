import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TaskListTest {

    TaskList taskList;
    Task task;

    @Before
    public void setUp() {
        task = new Task("haithem", "20-10-1985", "sda-6-lund");
        taskList = new TaskList();
        taskList.addTask(task);
    }

    @Test
    public void addTask() {

        assertEquals(1,taskList.getTaskArrayList().size());
    }



    @Test
    public void removeTask() {
        taskList.removeTask("haithem");
        assertEquals(0,taskList.getTaskArrayList().size());
    }



    @Test
    public void findTask() {

        //assertEquals("haithem ,20-10-1985 , sda-6-lund ,false ,null",taskList.findTask("haithem"));
        assertEquals(task,taskList.findTask("haithem"));
    }

    @Test
    public void markAsDone() {

        taskList.markAsDone("haithem");
        assertEquals(true,task.isStatusDone());
    }

    @Test
    public void updateTaskDescription() {
        taskList.updateTaskDescription("hello is it right","haithem");
        assertEquals("hello is it right",task.getDescription());
    }

    @Test
    public void updateTaskDate() {

        taskList.updateTaskDate("21-6-1993","haithem");
        assertEquals("21-6-1993",task.getDueDate());
    }

    @Test
    public void noOfToDo() {

        assertEquals(1,taskList.noOfToDo());
    }

    @Test
    public void noOfDone() {

        assertEquals(0,taskList.noOfDone());
    }
}