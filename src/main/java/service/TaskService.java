package service;

import dao.TaskDao;
import model.Task;
import java.util.List;

/**
 * Created by Ksimeo on 29.05.2014.
 */
public enum TaskService implements ITaskService
{
    INSTANCE;
    private List<Task> allTasks;
    TaskDao task;

    private TaskService()
    {
        task = new TaskDao();
        allTasks = task.getAllTasks();
    }

    public int getNewTaskId()
    {
        int id;
        if(allTasks.size() > 0)
        {
            id = allTasks.get(allTasks.size() - 1).getId() + 1;
        }
        else
        {
            id = 1;
        }

        return id;
    }

    public boolean addTask(String taskTitle, String description)
    {
        int id = getNewTaskId();
        Task t = new Task(id, taskTitle, description);
        allTasks.add(t);
        boolean f = task.addTask(t);
        allTasks.add(t);
        return f;
    }

    public List<Task> getAllTasks()
    {
        return allTasks;
    }
    public List<String> getAllTasksTitles(){return task.getAllTasksTitles();}
    public Task getTaskByTitle(String title){return task.getTaskByTitle(title);}
    @Override
    public Task  getTaskById(int id){return task.getTaskById(id);};

}
