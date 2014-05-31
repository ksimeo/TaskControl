package model;

/**
 * Created by user on 25.05.14.
 */
public class Task {
    private int id;
    private String taskTitle;
    private String description;

    public Task(int id, String taskTitle, String description) {
        this.id = id;
        this.taskTitle = taskTitle;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskTitle='" + taskTitle + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}