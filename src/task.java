public class task {

    private String title;
    private String DueDate;
    private String project;
    private boolean statusDone;
    private String description;

    public task(String title, String dueDate, String project) {
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
        return "title is " + title + " and DueDate is " + DueDate + " Project is " + project + " done " + statusDone + "\n" + " Description is " + description;

    }



}
