package servlets;

import dao.TaskDao;
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
        boolean isError = false;
        if(taskTitle == null || taskTitle.isEmpty()||description == null || description.isEmpty())
        {
            req.setAttribute("ErrorForm", "Fill all input field of new task, please!");
            isError = true;
        }
        else {
            TaskService newTask = TaskService.INSTANCE;
            Task task = newTask.addTask(taskTitle, description);
            if(task != null && !isError) {
                HttpSession session = req.getSession();
                session.setAttribute("task", task);
                List<Task> tasks = new ArrayList<>();
                session.setAttribute("Tasks", tasks);
                resp.sendRedirect("/secretPages/employer");
                session.setMaxInactiveInterval(30*60);
            }
            else {
                req.setAttribute("Error", "Your task is incorrect!");
                isError = true;
            }
        }
        if (isError){
            TaskDao td = new TaskDao();
            List<Task> task2 = td.getAllTasks();
            req.setAttribute("task", task2);
            req.getRequestDispatcher("/createnewtask.jsp").forward(req, resp);
        }
    }
}