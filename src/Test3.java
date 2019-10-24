import java.io.*;
import java.util.Collections;
import java.util.Scanner;


public class Test3 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Integer userInput;
        File file = new File("src/test2.txt");
        RWTasks rw = new RWTasks();
        TaskList taskArrayList = rw.Read(file);


//------------------User interface--------------------------//

        System.out.println("you have " + taskArrayList.noOfToDo() + " tasks to do " + taskArrayList.noOfDone() + " tasks have been done.");
        System.out.println("Pick an option:");
        System.out.println("(1) Show Task List (by date or project)");
        System.out.println("(2) Add New Task");
        System.out.println("(3) Edit Task (update, mark as done, remove)");
        System.out.println("(4) Save and Quit \n");

        boolean exit = false;
//------------------User input--------------------------//

        while (!exit) {

            userInput = scan.nextInt();
            switch (userInput) {

                case 1:
                    taskArrayList.sortByProject();
                    taskArrayList.print();
                    break;
                case 2:

                    System.out.println("please enter task title");
                    String taskTitle = scan.nextLine();
                    scan.next();
                    System.out.println("please enter task due date");
                    String due = scan.nextLine();
                    scan.next();
                    System.out.println("please assign project to the task");
                    String taskProject = scan.nextLine();
                    scan.next();
                    //task task=new task(taskTitle,due,taskProject);
                /*task.setDueDate(due);
                task.setProject(taskProject);
                task.setTitle(taskTitle);*/

                    taskArrayList.addTask(new Task(taskTitle, due, taskProject));
                    //taskArrayList.addTask(new task(taskTitle,due,taskProject));
                    //task task = new task(taskTitle, due, taskProject);
                    System.out.println("set task description");
                    String taskDescription = scan.nextLine();
                    scan.next();
                    taskArrayList.findTask(taskTitle).setDescription(taskDescription);
                    break;

                case 3:
                    System.out.println("(1) update task");
                    System.out.println("(2) mark task as done");
                    System.out.println("(3) remove task");
                    int userInput2 = scan.nextInt();
                    switch (userInput2) {
                        case 1:
                            System.out.println("(1) update task description");
                            System.out.println("(2) update task due date");
                            int userInput3 = scan.nextInt();
                            switch (userInput3) {
                                case 1:
                                    System.out.println("please enter the task title  to change its description");
                                    String changeTask = scan.next();
                                    System.out.println("please enter the new description");
                                    String changeDescription = scan.next();
                                    taskArrayList.updateTaskDescription(changeDescription, changeTask);
                                    break;
                                case 2:
                                    System.out.println("please enter the task title  to change its due date");
                                    String changeTaskDate = scan.next();
                                    System.out.println("please enter the new due date");
                                    String changeDate = scan.next();
                                    taskArrayList.updateTaskDate(changeDate, changeTaskDate);
                                    break;
                                default:
                                    break;

                            }

                        case 2:
                            System.out.println("please enter the task title to mark as done");
                            String mark = scan.next();
                            taskArrayList.markAsDone(mark);


                            break;
                        case 3:
                            System.out.println("please enter the task title to be deleted");
                            String taskRemove = scan.next();
                            taskArrayList.removeTask(taskRemove);
                            break;
                        default:
                            break;
                    }


                case 4:
                    exit = true;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + userInput);
            }

            rw.Write(file,taskArrayList);
        }
    }



}
