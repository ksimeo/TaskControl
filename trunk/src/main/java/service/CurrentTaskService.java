package service;

import dao.CurrentTaskDao;
import dao.ICurrentTask;
import model.CurrentTask;
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
    private AtomicInteger nextId;
    private ICurrentTask ctd;

    private CurrentTaskService()
    {

        ctd = new CurrentTaskDao();
        int lastId = ctd.getLastId();
        nextId = new AtomicInteger(lastId);

    }

    public boolean saveCurrentTask(int taskId, int creatorId, int recipientId, String state, String priority, Date createDate, Date startDate, Date endDate)
    {

        CurrentTask ct = new CurrentTask(nextId.get(), taskId, creatorId, recipientId, state, priority, createDate, startDate, endDate);

        boolean flag = ctd.saveCurrentTask(ct);
        nextId.incrementAndGet();
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

}
