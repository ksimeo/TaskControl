package helpers;

import com.sun.jmx.snmp.tasks.TaskServer;
import model.CurrentTask;
import model.Task;
import model.User;
import service.CurrentTaskService;
import service.TaskService;
import service.UserService;

import java.util.List;

/**
 * Created by VLAD on 03.06.2014.
 */
public class TaskHelper
{
    UserService userSer = UserService.INSTANCE;
    TaskService taskSer = TaskService.INSTANCE;
    CurrentTaskService curTaskSer = CurrentTaskService.INSTANCE;


    public List<String> getAllUsarsNames()
    {

        return userSer.getAllUsarsNames();

    }

    public List<String> getAllTasksTitles()
    {
        return taskSer.getAllTasksTitles();
    }

    public boolean saveCurrentTask(int taskId, int creatorId, int recipientId, String state, String priority)
    {
        return curTaskSer.saveCurrentTask(taskId, creatorId, recipientId, state, priority);
    }

    public User getUserByFullName(String fullName)
    {
        return userSer.searchUser(fullName);
    }

    public Task getTaskByTitle(String title)
    {
        return taskSer.getTaskByTitle(title);
    }
}
