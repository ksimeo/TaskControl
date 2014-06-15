package servlets;

import dao.TaskDao;
import helpers.TaskHelper;
import model.Task;
import service.TaskService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        String taskTitle = req.getParameter("title");
        String description = req.getParameter("description");

        boolean err = false;
        if(taskTitle.equals("") || description.equals(""))
//            if(taskTitle==null || taskTitle.isEmpty() || description == null || description.isEmpty())
        {
            req.setAttribute("ErrorForm", "Fill all input field of new task, please!");
            err = true;
        }
        else {
            TaskHelper th = new TaskHelper();
            th.saveTask(taskTitle, description);
        }

        //resp.sendRedirect("/secretPages/createnewtask.jsp");
        if(!err)
        {
            resp.sendRedirect("/secretPages/employer");
        }
        else {
            req.getRequestDispatcher("/secretPages/createnewtask.jsp").forward(req, resp);
        }
    }

}