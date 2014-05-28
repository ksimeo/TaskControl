package tests;

import dao.CurrentTaskDao;
import model.CurrentTask;
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
        Date d = new Date();
        CurrentTaskService cts = new CurrentTaskService();

        // Saving new current tasks --------------
//        boolean res1 = cts.saveCurrentTask(1, 4, 9, CurrentTask.START, d, d, d);
//        System.out.println("Operetion res1 is " + res1);
//        boolean res2 = cts.saveCurrentTask(2, 2, 1, CurrentTask.IN_PROCESS, d, d, d);
//        System.out.println("Operetion res2 is " + res2);
//        boolean res3 = cts.saveCurrentTask(3, 2, 9, CurrentTask.FINISH, d, d, d);
//        System.out.println("Operetion res2 is " + res3);
        print(cts.getAllCurrentTasks());


        // getting all users by userId --------------
//        User user = new User("Vasya Pupkin","vasya123", "qwert", 1);
//        user.setUserId(9);
//        print(cts.getAllByUserId(user));



    }

    public static void print(List<CurrentTask> ctasks)
    {
        Iterator<CurrentTask> iter = ctasks.iterator();
        while (iter.hasNext())
        {
            System.out.println(iter.next());
        }
    }
}
