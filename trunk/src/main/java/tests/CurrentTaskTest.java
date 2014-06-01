package tests;

import model.CurrentTask;
import model.Parcel;
import model.Task;
import model.User;
import service.CurrentTaskService;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by VLAD on 27.05.2014.
 */

public class CurrentTaskTest
{
    public static void main (String[] args)
    {
        //Date d = new Date();
        CurrentTaskService cts = CurrentTaskService.INSTANCE;

        //Saving new current tasks --------------
//        boolean res1 = cts.saveCurrentTask(1, 4, 2, CurrentTask.START, "HAIGHT");
//        System.out.println("Operation res1 is " + res1);
//        boolean res2 = cts.saveCurrentTask(2, 2, 3, CurrentTask.IN_PROCESS, "MIDDLE");
//        System.out.println("Operation res2 is " + res2);
//        boolean res3 = cts.saveCurrentTask(3, 2, 1, CurrentTask.FINISH, "LOW");
//        System.out.println("Operation res2 is " + res3);
//        System.out.println("Saving is ready");

////        //getting all --------------
//        User recipient = new User("Vasya Pupkin","vasya123", "qwert", 1);
//        recipient.setUserId(1);
//        User creator = new User("Kolya, Pupkin","vasya123", "qwert", 1);
//        creator.setUserId(2);
//        Task task1 = new Task(1,"Title","Some rules");
//
//        // getting all current tasks --------------
//        print(cts.getAllCurrentTasks());
//        // getting all current tasks by recipient id --------------
//        print(cts.getAllByUserId(recipient));
//        // getting all current tasks by creator id --------------
//        print(cts.getAllByCreatorId(creator));
//        // getting all current tasks by task id --------------
//        print(cts.getAllByTaskId(task1));
//        Parcel<CurrentTask> parcel = cts.getCurrentTaskPage(recipient, 1, 5);
//        System.out.println(parcel.getCount());
//        print(parcel.getPage());

        // Updating start and finish dates into current tasks --------------
//        CurrentTask ct = new CurrentTask(2,2,2,3, "CurrentTask.IN_PROCESS","MIDDLE", new Date());
//        cts.setStartDate(ct);
//        cts.setEndDate(ct);

        // Updating priority into current tasks --------------
        CurrentTask ct = new CurrentTask(2,2,2,3, CurrentTask.STATUS_IN_PROCESS,CurrentTask.PRIORITY_MIDDLE, new Date());
        cts.setPriority(ct, CurrentTask.PRIORITY_HEIGHT);
    }

    public static void print(List<CurrentTask> ctasks)
    {
        Iterator<CurrentTask> iter = ctasks.iterator();
        while (iter.hasNext())
        {
            System.out.println(iter.next());
        }
        System.out.println("--------------------");
    }
}
