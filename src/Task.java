
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;


public class Task implements Comparable<Task> {


    private String title;
    private String DueDate;
    private String project;
    private boolean statusDone;
    private String description;



    public Task(String title, String dueDate, String project) {
        this.title = title;
        DueDate = dueDate;
        this.project = project;
        this.statusDone = false;
    }

    public boolean isStatusDone() {
        return statusDone;
    }

    public void setStatusDone(boolean statusDone) {
        this.statusDone = statusDone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDueDate() {
        return DueDate;
    }

    public void setDueDate(String dueDate) {
        DueDate = dueDate;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return  title + " ," + DueDate + " , " + project + " ," + statusDone  + " ," + description;

    }

    public boolean equals(Task t){
        return t.title.equals(title);
    }




    @Override
     public int compareTo(Task o) {
         return this.getProject().compareTo(o.getProject());
     }

    public static Comparator<Task> compareByDate = new Comparator<Task>() {
        @Override
        public int compare(Task o1, Task o2) {
            return o1.getDueDate().compareTo(o2.getDueDate());
        }
    };

}
