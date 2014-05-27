package dao.tests;

import dao.CurrentTaskDao;
import model.CurrentTask;

import java.util.Date;

/**
 * Created by VLAD on 27.05.2014.
 */

public class CurrentTaskTest
{
    public static void main (String[] args)
    {

        Date d = new Date();
        CurrentTask ct = new CurrentTask(1, 1, 1, 1, "in process", d, d, d);
        CurrentTaskDao ctd = new CurrentTaskDao();
        boolean res = ctd.saveCurrentTask(ct);
        System.out.println("Operetion is " + res);
        if (res) {
            System.out.println(ct);
        }
        System.out.println("-------------------------");
        System.out.println(ctd.getAllCarrentTasks());

    }
}
