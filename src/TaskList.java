import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaskList {
    //ArrayList<task>taskArrayList=new ArrayList<>();
   ArrayList<Task> taskArrayList;


    // constructor called on initialization e.g. new TaskList();
    public TaskList() {
        this.taskArrayList = new ArrayList<>();
    }

    public ArrayList<Task> getTaskArrayList() {
        return taskArrayList;
    }

    public void setTaskArrayList(ArrayList<Task> taskArrayList) {
        this.taskArrayList = taskArrayList;
    }

    public void addTask(Task task){
        taskArrayList.add(task);
    }

    public void print(){
        for(Task i:taskArrayList){
            System.out.println(i);

        }

        }

    public void removeTask(String title) {
        Task c = this.findTask(title);
        if (c != null) {
            this.taskArrayList.remove(c);
        }
    }
    public Task findTask(String title) {
        for (Task c :taskArrayList) {
            if (c.getTitle().equals(title)) {
                return c;
            }
        }

        return null;

    }

    public void markAsDone(String title){
        Task tmp=this.findTask(title);
        tmp.setStatusDone(true);
        System.out.println(tmp.isStatusDone());



    }

    public void  updateTaskDescription(String newDescription, String title){
        Task tmp=this.findTask(title);
        tmp.setDescription(newDescription);

    }

    public void updateTaskDate(String newDate, String title){
        Task tmp= this.findTask(title);
        tmp.setDueDate(newDate);
    }





    public int noOfToDo(){
        int toDo = 0;
        for(Task i : this.taskArrayList){

            if (i.isStatusDone() == false){

                toDo++;
           }


        }

        return toDo;
    }


    public int noOfDone(){
        int done= 0;
        for(Task i : taskArrayList){

            if (i.isStatusDone() == true){

                done++;
            }


        }
        return done;
    }

    public void sortByProject(){
        Collections.sort(this.getTaskArrayList());

    }
    public void sortByDate(){
        Collections.sort(this.getTaskArrayList(), Task.compareByDate );

    }






}

