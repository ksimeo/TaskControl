package service;

import dao.TaskDao;
import model.Task;
import java.util.List;

/**
 * Created by Ksimeo on 29.05.2014.
 */
public class TaskService {

    TaskDao task = new TaskDao();
    List<Task> allTasks = task.getAllTasks();

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

    public boolean addNewTask(String taskTitle, String description)
    {
        int id = getNewTaskId();
        Task t = new Task(id, taskTitle, description);
        allTasks.add(t);
        boolean f = TaskDao.addTask(t);
        allTasks.add(t);
        return f;
    }

    public List<Task> getAllTasks()
    {
        return allTasks;
    }
}
