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

//        boolean res1 = cts.saveCurrentTask(1, 4, 9, "made", d, d, d);
//        System.out.println("Operetion res1 is " + res1);
//        boolean res2 = cts.saveCurrentTask(2, 2, 1, "waits", d, d, d);
//        System.out.println("Operetion res2 is " + res2);
//        print(cts.getAllCurrentTasks());
        User user = new User(9, "Vasya Pupkin","vasya123", "qwert", 1);



        print(cts.getAllByUserId(user)); // getting all users by userId



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
