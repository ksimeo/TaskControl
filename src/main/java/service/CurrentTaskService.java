package service;

import dao.CurrentTaskDao;
import model.CurrentTask;
import model.User;

import java.util.Date;
import java.util.List;

/**
 * Created by VLAD on 27.05.2014.
 */
public class CurrentTaskService
{
    int nextId;
    CurrentTaskDao ctd;
    List<CurrentTask> ctasks;

    public CurrentTaskService()
    {
        ctd = new CurrentTaskDao();
        ctasks = ctd.getAllCarrentTasks();
        if(ctasks.size() > 0) {
            nextId = ctasks.get(ctasks.size() - 1).getId() + 1;
        }else {
            nextId = 0;
        }

    }

    public boolean saveCurrentTask(int taskId, int creatorId, int recipientId, String state, Date createDate, Date startDate, Date endDate)
    {

        CurrentTask ct = new CurrentTask(nextId, taskId, creatorId, recipientId, state, createDate, startDate, endDate);

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

}
