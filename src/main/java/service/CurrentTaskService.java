package service;

import dao.CurrentTaskDao;
import model.CurrentTask;
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
        nextId = ctasks.get(ctasks.size()-1).getId() + 1;


    }

    public boolean saveCurrentTask(int taskId, int creatorId, int recipientId, String state, Date createDate, Date startDate, Date endDate)
    {
        CurrentTask ct = new CurrentTask(nextId, taskId, creatorId, recipientId, state, createDate, startDate, endDate);
        boolean flag = ctd.saveCurrentTask(ct);
        ctasks.add(ct);
        nextId++;
        return flag;
    }

    public List<CurrentTask> getAllCarrentTasks()
    {
        return ctasks;
    }
}
