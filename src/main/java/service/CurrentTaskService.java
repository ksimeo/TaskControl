package service;

import dao.CurrentTaskDao;
import dao.ICurrentTask;
import model.CurrentTask;
import model.Task;
import model.User;

import java.util.Date;
import java.util.List;

/**
 * Created by VLAD on 27.05.2014.
 */
public class CurrentTaskService
{
    int nextId;
    ICurrentTask ctd;
    List<CurrentTask> ctasks;

    public CurrentTaskService()
    {
        ctd = new CurrentTaskDao();
        ctasks = ctd.getAllCurrentTasks();
        if(ctasks.size() > 0) {
            nextId = getLastId() + 1;
        }else {
            nextId = 1;
        }

    }

    public boolean saveCurrentTask(int taskId, int creatorId, int recipientId, String state, String priority, Date createDate, Date startDate, Date endDate)
    {

        CurrentTask ct = new CurrentTask(nextId, taskId, creatorId, recipientId, state, priority, createDate, startDate, endDate);

        boolean flag = ctd.saveCurrentTask(ct);
        ctasks.add(ct);
        nextId++;
        return flag;
    }

    public List<CurrentTask> getAllCurrentTasks()
    {
        return ctasks;
    }

    public List<CurrentTask> getAllByUserId(User user)
    {
        List<CurrentTask> ctasks = ctd.getAllByUserId(user);
        return ctasks;
    }

    public List<CurrentTask> getAllByCreatorId(User user)
    {
        List<CurrentTask> ctasks = ctd.getAllByCreatorId(user);
        return ctasks;

    }

    public List<CurrentTask> getAllByTaskId(Task task)
    {
        return ctd.getAllByTaskId(task);
    }

    public int getLastId()
    {
        return ctd.getLastId();
    }

}
