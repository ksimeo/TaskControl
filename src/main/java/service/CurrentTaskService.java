package service;

import dao.CurrentTaskDao;
import dao.ICurrentTaskDao;
import model.CurrentTask;
import model.Parcel;
import model.Task;
import model.User;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by VLAD on 27.05.2014.
 */
public enum CurrentTaskService
{
    INSTANCE;
    private AtomicInteger lastId;
    private ICurrentTaskDao ctd;

    private CurrentTaskService()
    {

        ctd = new CurrentTaskDao();
        int lId = ctd.getLastId();
        lastId = new AtomicInteger(lId);


    }

    public boolean saveCurrentTask(int taskId, int creatorId, int recipientId, String state, String priority, Date createDate, Date startDate, Date endDate)
    {

        CurrentTask ct = new CurrentTask(lastId.incrementAndGet(), taskId, creatorId, recipientId, state, priority, createDate, startDate, endDate);

        boolean flag = ctd.saveCurrentTask(ct);
        return flag;
    }

    public List<CurrentTask> getAllCurrentTasks()
    {
        return ctd.getAllCurrentTasks();
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

    public Parcel<CurrentTask> getCurrentTaskPage(User user, int from, int to)
    {
        return ctd.getCurrentTaskPage(user, from, to);
    }

}
