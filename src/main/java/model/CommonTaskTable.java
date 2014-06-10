package model;

/**
 * Created by Avega on 10.06.14.
 */
public class CommonTaskTable
{
    CurrentTask currentTask;
    Task task;
    User user;

    public CommonTaskTable(CurrentTask currentTask, Task task, User user)
    {
        this.currentTask = currentTask;
        this.task = task;
        this.user = user;
    }

    public CurrentTask getCurrentTask() {
        return currentTask;
    }

    public void setCurrentTask(CurrentTask currentTask) {
        this.currentTask = currentTask;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
