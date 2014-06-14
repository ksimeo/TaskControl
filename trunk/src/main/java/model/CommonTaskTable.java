package model;

/**
 * Created by Avega on 10.06.14.
 */
public class CommonTaskTable
{
    CurrentTask currentTask;
    Task task;
    User creator;
    User recipient;

    public CommonTaskTable(CurrentTask currentTask, Task task, User creator)
    {
        this.currentTask = currentTask;
        this.task = task;
        this.creator = creator;
    }

    public CommonTaskTable(CurrentTask currentTask, Task task, User creator, User recipient) {
        this.currentTask = currentTask;
        this.task = task;
        this.creator = creator;
        this.recipient = recipient;
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


    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }
}
