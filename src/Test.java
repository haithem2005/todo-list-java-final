import java.io.FileInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Test {



    public static void main(String[] args) throws IOException {
       Task task1 = new Task("task1", "1-1-2001", "project1");
       Task task2 = new Task("task2", "2-2-2002", "project2");
       Task task3 = new Task("task3", "3-3-2003", "project3");
       Task task4 = new Task("task4","4-4-2004","project4");

        Scanner scan = new Scanner(System.in);
        int userInput;


        //task2.setDescription("hello i am here");

        TaskList taskArrayList = new TaskList();

        //taskArrayList.addTask(task1);
        //taskArrayList.addTask(task2);
        //taskArrayList.addTask(task3);



        System.out.println(taskArrayList.findTask("task1"));

        /* --------------READ FROM A FILE--------------------------------- */
        File file = new File("src/test2.txt");

        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            System.out.println("file size is " + fileInputStream.available());
            int content;
            while ((content = fileInputStream.read()) != -1) {
                System.out.print((char) content);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // taskArrayList = (TaskList) oi.readObject();

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
                String taskTitle=scan.next();
                System.out.println("please enter task due date");
                String due=scan.next();
                System.out.println("please assign project to the task");
                String taskProject= scan.next();
                //task task=new task(taskTitle,due,taskProject);
                /*task.setDueDate(due);
                task.setProject(taskProject);
                task.setTitle(taskTitle);*/

                taskArrayList.addTask(new Task(taskTitle,due,taskProject));
                //taskArrayList.addTask(new task(taskTitle,due,taskProject));
                //task task = new task(taskTitle, due, taskProject);
                System.out.println("set task description");
                String taskDescription = scan.next();
                taskArrayList.findTask(taskTitle).setDescription(taskDescription);
                break;

            case 3:
                System.out.println("(1) update task");
                System.out.println("(2) mark task as done");
                System.out.println("(3) remove task");
                int userInput2=scan.nextInt();
                switch (userInput2){
                    case 1:
                        System.out.println("(1) udate task description");
                        System.out.println("(2) udate task due date");
                        int userInput3=scan.nextInt();
                        switch (userInput3){
                            case 1:
                                System.out.println("please enter the task title  to change its description");
                                String changeTask =  scan.next();
                                System.out.println("please enter the new description");
                                String changeDesription = scan.next();
                                taskArrayList.updateTaskDescription(changeDesription,changeTask);
                                break;
                            case 2:
                                System.out.println("please enter the task title  to change its due date");
                                String changeTaskDate =  scan.next();
                                System.out.println("please enter the new due date");
                                String changeDate = scan.next();
                                taskArrayList.updateTaskDate(changeDate,changeTaskDate);
                                break;
                            default:
                                throw new IllegalStateException("Unexpected value: " + userInput);
                        }
                    case 2:
                        System.out.println("please enter the task title to mark as done");
                        String mark=scan.next();
                        taskArrayList.markAsDone(mark);



                        break;
                    case 3:
                        System.out.println("please enter the task title to be deleted");
                        String taskRemove=scan.next();
                        taskArrayList.removeTask(taskRemove);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + userInput);
                }



            default:
                break;
        }




        /* ----------------WRITE TO A FILE----------------------------------- */


        try (FileWriter fileWriter = new FileWriter(file.getAbsoluteFile(),true)) {
            //fileWriter.write("again \n");
            //fileWriter.write(task1.toString() + "\n");

            //fileWriter.write(taskArrayList + "\n");
            //fileWriter.write(taskArrayList.getTaskArrayList() + "\n");
            for (Task i : taskArrayList.getTaskArrayList()) {
                fileWriter.write(i + "\n");

            }

            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}
