package dao;

import model.CurrentTask;
import model.Parcel;
import model.Task;
import model.User;

import java.util.List;

/**
 * Created by user on 01.06.14.
 */
public interface ICurrentTaskDao
{
    public boolean saveCurrentTask(CurrentTask ct);
    public List<CurrentTask> getAllCurrentTasks();
    public List<CurrentTask> getAllByUserId(User user);
    public List<CurrentTask> getAllByCreatorId(User user);
    public List<CurrentTask> getAllByTaskId(Task task);
    public Parcel<CurrentTask> getCurrentTaskPage(User user, int from, int to);
    public int getLastId();
}
