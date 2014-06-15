package service;

import dao.ITaskDao;
import dao.TaskDao;
import dao.UserDao;
import model.Task;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Ksimeo on 29.05.2014.
 */
public enum TaskService implements ITaskService
{
    INSTANCE;
    //private List<Task> allTasks;
    //private TaskDao task;
    private AtomicInteger lastId;
    private ITaskDao td;

////    private TaskService()
//    {
//        task = new TaskDao();
//    }

    private TaskService()
    {
        td = new TaskDao();
        int lId = td.getLastId();
        lastId = new AtomicInteger(lId);
    }



    public Task addTask(String taskTitle, String description)
    {

        Task t = new Task(lastId.incrementAndGet(), taskTitle, description);
        return td.addTask(t) ? t : null;
    }

    public List<Task> getAllTasks()
    {
        return td.getAllTasks();
    }
    public List<String> getAllTasksTitles(){return td.getAllTasksTitles();}
    public Task getTaskByTitle(String title){return td.getTaskByTitle(title);}
    @Override
    public Task  getTaskById(int id){return td.getTaskById(id);};

    @Override
    public void setDescription(String title, String description)
    {
        td.setDescription(title, description);
    }

}
