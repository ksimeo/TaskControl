package tests;

import dao.TaskDao;
import model.Task;
import service.TaskService;

import java.util.List;
import java.util.Iterator;

/**
 * Created by Ksimeo on 27.05.2014.
 */

public class TaskDaoTest {

    public static void main(String[] args)
    {
        //TaskDao td = new TaskDao();
        TaskService ts = TaskService.INSTANCE;
        Task newTask = new Task( 1, "Погрузка", "Грузите ананасы бочками!");

        if (ts.addTask("Погрузка", "Грузите ананасы бочками!") != null)
        {
            System.out.println("SUCCESS");
        }
        else
        {
            System.out.println("Error");
        }

        List<Task> db = ts.getAllTasks();

        Task res = ts.addTask("Погрузка", "Грузите ананасы бочками!");
        System.out.println("RES: " + res);
        db = ts.getAllTasks();
        showTasks(db);
    }

    private static void showTasks(List<Task> all)
    {
        Iterator<Task> iter = all.iterator();
        Task tmp;
        while (iter.hasNext())
        {
            tmp = iter.next();
            System.out.println(tmp);
        }
    }
}
