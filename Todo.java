public class Todo {

    private String task;
    private String priority;
    private boolean completed;

    public Todo(String task, String priority){

        this.task = task;
        this.priority = priority;
        this.completed = false;
    }

    public void complete(){

        completed = true;
    }

    public String getTask(){

        return task;
    }
public String getPriority(){

    return priority;
}

public boolean isCompleted(){

    return completed;
}
    @Override
    public String toString(){

        String mark =
                completed ? "[✔]" : "[ ]";

        return mark +
                " (" + priority.toUpperCase() + ") "
                + task;
    }
}