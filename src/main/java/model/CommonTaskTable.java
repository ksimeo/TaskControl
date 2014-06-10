package model;

/**
 * Created by Avega on 10.06.14.
 */
public class CommonTaskTable
{
    CurrentTask currentTask;
    Task task;

    public CommonTaskTable(CurrentTask currentTask, Task task)
    {
        this.currentTask = currentTask;
        this.task = task;
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
}
