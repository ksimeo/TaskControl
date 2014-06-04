package helpers;

import com.sun.jmx.snmp.tasks.TaskServer;
import service.TaskService;
import service.UserService;

import java.util.List;

/**
 * Created by VLAD on 03.06.2014.
 */
public class TaskHelper
{
    UserService userviSer = UserService.INSTANCE;
    TaskService taskSer = TaskService.INSTANCE;


    public List<String> getAllUsarsNames()
    {

        return userviSer.getAllUsarsNames();

    }

    public List<String> getAllTasksTitles()
    {
        return taskSer.getAllTasksTitles();
    }
}
