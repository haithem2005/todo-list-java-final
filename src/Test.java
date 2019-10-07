import java.io.FileInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Test {



    public static void main(String[] args) throws IOException {
       task task1 = new task("task1", "1-1-2001", "project1");
       task task2 = new task("task2", "2-2-2002", "project2");
       task task3 = new task("task3", "3-3-2003", "project3");
       task task4 = new task("task4","4-4-2004","project4");

        Scanner scan = new Scanner(System.in);
        int userInput;


        task2.setDescription("hello i am here");

        TaskList taskArrayList = new TaskList();

        taskArrayList.addTask(task1);
        taskArrayList.addTask(task2);
        taskArrayList.addTask(task3);

        System.out.println("You have "+ taskArrayList.noOfToDo()+ " tasks to do and you have "+ taskArrayList.noOfDone() + " tasks have been done.");


        System.out.println("Pick an option:");
        System.out.println("(1) Show Task List (by date or project)");
        System.out.println("(2) Add New Task");
        System.out.println("(3) Edit Task (update, mark as done, remove)");
        System.out.println("(4) Save and Quit \n");

        userInput = scan.nextInt();
        switch (userInput){
            case 2 :
                System.out.println("please enter task title");
                String taskTitle=scan.nextLine();
                scan.next();
                System.out.println("please enter task due date");
                String due=scan.nextLine();
                scan.next();
                System.out.println("please assign project to the task");
                String taskProject= scan.nextLine();
                scan.next();
               task task=new task(taskTitle,due,taskProject);
               task.setDueDate(due);
               task.setProject(taskProject);
               task.setTitle(taskTitle);
                taskArrayList.addTask(task);
                //taskArrayList.addTask(new task(taskTitle,due,taskProject));
                //task task = new task(taskTitle, due, taskProject);
                System.out.println("set task description");
                String taskDescription = scan.nextLine();
                scan.next();
                taskArrayList.findTask(taskTitle).setDescription(taskDescription);

                
                break;


            default:
                throw new IllegalStateException("Unexpected value: " + userInput);
        }






        /* ----------------WRITE TO A FILE----------------------------------- */
        File file = new File("src/test2.rtf");

        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write("again \n");
            //fileWriter.write(task1.toString() + "\n");

            fileWriter.write(taskArrayList + "\n");
            fileWriter.write(taskArrayList.getTaskArrayList() + "\n");
            for (task i : taskArrayList.getTaskArrayList()) {
                fileWriter.write(i + "\n");
            }

            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /* --------------READ FROM A FILE--------------------------------- */


        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            System.out.println("file size is " + fileInputStream.available());
            int content;
            while ((content = fileInputStream.read()) != -1) {
                System.out.print((char) content);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
