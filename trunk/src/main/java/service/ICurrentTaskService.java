package service;

import model.CurrentTask;
import model.Parcel;
import model.Task;
import model.User;

import java.util.Date;
import java.util.List;

/**
 * Created by user on 01.06.14.
 */
public interface ICurrentTaskService
{
    public boolean saveCurrentTask(int taskId, int creatorId, int recipientId, String state, String priority);
    public List<CurrentTask> getAllCurrentTasks();
    public List<CurrentTask> getAllByUserId(User user);
    public List<CurrentTask> getAllByCreatorId(User user);
    public List<CurrentTask> getAllByTaskId(Task task);
    public Parcel<CurrentTask> getCurrentTaskPage(User user, int from, int to);
    public boolean setStartDate(CurrentTask ct);
    public boolean setEndDate(CurrentTask ct);
    public boolean setPriority(CurrentTask ct, String priority);
}
