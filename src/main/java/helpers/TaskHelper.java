package helpers;

import com.sun.jmx.snmp.tasks.TaskServer;
import model.CurrentTask;
import model.Task;
import model.User;
import service.CurrentTaskService;
import service.TaskService;
import service.UserService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
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

    public CurrentTask saveCurrentTask(int taskId, int creatorId, int recipientId, String priority)
    {
        return curTaskSer.saveCurrentTask(taskId, creatorId, recipientId, priority);
    }

    public User getUserByFullName(String fullName)
    {
        return userSer.searchUser(fullName);
    }

    public Task getTaskByTitle(String title)
    {
        return taskSer.getTaskByTitle(title);
    }

    public List<String> ConvertToShow(List<CurrentTask> currentTasks)
    {
        List<String> toReturn = new ArrayList<>();
        Iterator<CurrentTask> iter = currentTasks.iterator();
        while (iter.hasNext())
        {
            CurrentTask tmp = iter.next();
            StringBuilder sb = new StringBuilder();
            SimpleDateFormat sdformat = new SimpleDateFormat("dd.MM.yy hh:mm");
            sb.append(userSer.getUserById(tmp.getRecepientId()).getName())
                    .append(" ")
                    .append(taskSer.getTaskById(tmp.getTaskId()).getTaskTitle())
                    .append(" ")
                    .append(tmp.getPriority())
                    .append(" ")
                    .append(tmp.getState())
                    .append(" ")
                    .append(sdformat.format(tmp.getCreateDate()));

            toReturn.add(sb.toString());
        }

        return toReturn;
    }
}
