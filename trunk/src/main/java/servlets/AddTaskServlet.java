package servlets;

import helpers.TaskHelper;
import model.Task;
import service.TaskService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Iterator;

/**
 * Created by Ksimeo on 09.06.2014.
 */

@WebServlet (urlPatterns = "/createnewtask")
public class AddTaskServlet extends HttpServlet {

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        List<Task> task = TaskService.INSTANCE.getAllTasks();

        req.setAttribute("task",task);
        req.getRequestDispatcher("/secretPages/createnewtask.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        try {
            req.setCharacterEncoding("UTF-8");
            String taskTitle = req.getParameter("title");
//            System.out.println(taskTitle);
//        String taskTitle = new String(req.getParameter("title").getBytes("ISO-8859-1"), "Cp1251");
            String description = req.getParameter("description");
//        String description = new String(req.getParameter("description").getBytes("ISO-8859-1"), "Cp1251");
            TaskHelper th = new TaskHelper();
            boolean err = false;
            List<String> taskTitles = th.getAllTasksTitles();
            Iterator<String> iter = taskTitles.iterator();
            while (iter.hasNext()) {
                String tmp = iter.next();
//                System.out.print(tmp);
                if (tmp.equalsIgnoreCase(taskTitle)) {
                    req.setAttribute("ErrorForm", "Task with the same title already exists!");
                    err = true;
                    break;
                }
            }

            if (taskTitle.equals("") || description.equals("")) {
                req.setAttribute("ErrorForm", "Fill all input field of new task, please!");
                err = true;
            } else {
                th.saveTask(taskTitle, description);
            }

            if (!err) {
                resp.sendRedirect("/secretPages/employer");
            } else {
                req.getRequestDispatcher("/secretPages/createnewtask.jsp").forward(req, resp);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}