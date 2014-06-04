package helpers;

import model.CurrentTask;
import service.CurrentTaskService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by VLAD on 03.06.2014.
 */
public class TaskHelper
{
    public List<String> getAllCurrentTasks()
    {
        CurrentTaskService cts = CurrentTaskService.INSTANCE;
        ArrayList<CurrentTask> ctasks = (ArrayList) cts.getAllCurrentTasks();
        ArrayList<String> toSend = new ArrayList<>();
        Iterator<CurrentTask> iter = ctasks.iterator();
        while (iter.hasNext())
        {
            toSend.add(iter.next().toString());
        }
        return toSend;
    }
}
