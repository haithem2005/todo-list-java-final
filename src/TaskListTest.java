import org.junit.Test;

import static org.junit.Assert.*;

public class TaskListTest {

    @Test
    public void addTask() {
        Task task=new Task("haithem","20-10-1985","sda-6-lund");
        TaskList taskList= new TaskList();
        taskList.addTask(task);
        assertEquals(1,taskList.getTaskArrayList().size());
    }

    @Test
    public void print() {
    }

    @Test
    public void removeTask() {
        Task task=new Task("haithem","20-10-1985","sda-6-lund");
        TaskList taskList= new TaskList();
        taskList.addTask(task);
        taskList.removeTask("haithem");
        assertEquals(0,taskList.getTaskArrayList().size());
    }

    @Test
    public void findTask() {
        Task task=new Task("haithem","20-10-1985","sda-6-lund");
        TaskList taskList= new TaskList();
        taskList.addTask(task);
        //assertEquals("haithem ,20-10-1985 , sda-6-lund ,false ,null",taskList.findTask("haithem"));
        assertEquals(task,taskList.findTask("haithem"));
    }

    @Test
    public void markAsDone() {
        Task task=new Task("haithem","20-10-1985","sda-6-lund");
        TaskList taskList= new TaskList();
        taskList.addTask(task);
        taskList.markAsDone("haithem");
        assertEquals(true,task.isStatusDone());
    }

    @Test
    public void updateTaskDescription() {
        Task task=new Task("haithem","20-10-1985","sda-6-lund");
        TaskList taskList= new TaskList();
        taskList.addTask(task);
        taskList.updateTaskDescription("hello is it right","haithem");
        assertEquals("hello is it right",task.getDescription());
    }

    @Test
    public void updateTaskDate() {
        Task task=new Task("haithem","20-10-1985","sda-6-lund");
        TaskList taskList= new TaskList();
        taskList.addTask(task);
        taskList.updateTaskDate("21-6-1993","haithem");
        assertEquals("21-6-1993",task.getDueDate());
    }

    @Test
    public void noOfToDo() {
        Task task=new Task("haithem","20-10-1985","sda-6-lund");
        TaskList taskList= new TaskList();
        taskList.addTask(task);
        assertEquals(1,taskList.noOfToDo());
    }

    @Test
    public void noOfDone() {
        Task task=new Task("haithem","20-10-1985","sda-6-lund");
        TaskList taskList= new TaskList();
        taskList.addTask(task);
        assertEquals(0,taskList.noOfDone());
    }
}