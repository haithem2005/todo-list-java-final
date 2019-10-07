import java.util.ArrayList;
import java.io.File;
import java.io.IOException;

public class TaskList  {
    ArrayList<task>taskArrayList=new ArrayList<>();


    public ArrayList<task> getTaskArrayList() {
        return taskArrayList;
    }

    public void setTaskArrayList(ArrayList<task> taskArrayList) {
        this.taskArrayList = taskArrayList;
    }

    public void addTask(task task){
        taskArrayList.add(task);
    }

    public void print(){
        for(task i:taskArrayList){
            System.out.println(i);

        }

        }

    public void removeTask(String title) {
        task c = this.findTask(title);
        if (c != null) {
            this.taskArrayList.remove(c);
        }
    }
    public task findTask(String title) {
        for (task c :this.taskArrayList) {
            if (c.getTitle().equals(title)) {
                return c;
            }
        }

        return null;

    }




    public int noOfToDo(){
        int toDo = 0;
        for(task i : taskArrayList){

            if (i.isStatusDone() == false){

                toDo++;
           }


        }
        return toDo;
    }


    public int noOfDone(){
        int done= 0;
        for(task i : taskArrayList){

            if (i.isStatusDone() == true){

                done++;
            }


        }
        return done;
    }




}
