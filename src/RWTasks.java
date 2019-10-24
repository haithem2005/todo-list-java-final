import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RWTasks {
    /* ----------------WRITE TO A FILE----------------------------------- */
    public void Write(File file, TaskList taskArrayList)  {
        try(
                FileWriter fileWriter = new FileWriter(file.getAbsoluteFile()))

        {
            //fileWriter.write("again \n");
            //fileWriter.write(task1.toString() + "\n");

            //fileWriter.write(taskArrayList + "\n");
            //fileWriter.write(taskArrayList.getTaskArrayList() + "\n");
            for (Task i : taskArrayList.getTaskArrayList()) {


                // fileWriter.write((i.getTitle() + "," + i.getDueDate() + "!" + i.getProject() + "#" + i.isStatusDone() + "&" + i.getDescription()) + "\n");
                fileWriter.write((i.getTitle() + "," + i.getDueDate() + "," + i.getProject() + "," + i.isStatusDone() + "," + i.getDescription()) + "\n");

            }

            fileWriter.close();
        } catch(
                IOException e)

        {
            e.printStackTrace();

        }
 }


    /* --------------READ FROM A FILE--------------------------------- */

        /*
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
                    System.out.println("file size is " + fileInputStream.available());
                    int content;
                    while ((content = fileInputStream.read()) != -1) {
                        System.out.print((char) content);
                        //String taskTitle=fileInputStream.toString().lines().
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

                // taskArrayList = (TaskList) oi.readObject();

                System.out.println("You have "+ taskArrayList.noOfToDo()+ " tasks to do and you have "+ taskArrayList.noOfDone() + " tasks have been done.");
        */



    /* --------------Another READ FROM A FILE--------------------------------- */

    public TaskList Read(File file) {
        TaskList taskArrayList = new TaskList();
        try {
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            while (raf.getFilePointer() < raf.length()) {
                String taskObject = raf.readLine();

                String[] taskdetails = taskObject.split(",", 0);
                String taskTitle = taskdetails[0];
                String taskDuedate = taskdetails[1];
                String taskProject = taskdetails[2];
                String taskStatus = taskdetails[3];
                String taskDescription = taskdetails[4];
                Task tempT = new Task(taskTitle, taskDuedate, taskProject);
                taskArrayList.addTask(tempT);
                if(taskdetails[3].equals("true"))
                    tempT.setStatusDone(true);
                taskArrayList.findTask(taskTitle).setDescription(taskDescription);


               /*for (int i = 0; i < taskdetails.length; i++) {
                    System.out.println(taskdetails[i]);
                }
*/

            }


        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return taskArrayList;
    }
}
