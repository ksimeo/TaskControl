package tests;

import dao.TaskDao;
import model.Task;

import java.util.List;
import java.util.Iterator;

/**
 * Created by Ksimeo on 27.05.2014.
 */

public class TaskDaoTest {

    public static void main(String[] args)
    {
        TaskDao td = new TaskDao();
        Task newTask = new Task( 1, "Погрузка", "Грузите ананасы бочками!");

        if (td.addTask(newTask))
        {
            System.out.println("SUCCESS");
        }
        else
        {
            System.out.println("Error");
        }

        List<Task> db = TaskDao.getAllTasks();

        boolean res = td.addTask(newTask);
        System.out.println("RES: " + res);
        db = TaskDao.getAllTasks();
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
