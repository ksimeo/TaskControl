package servlets;

import model.Role;
import service.RoleService;
import service.TaskService;
import model.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 09.06.2014.
 */

@WebServlet (urlPatterns = "/createnewtask")
public class AddTaskServlet {

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String taskTitle = req.getParameter("title");
        String description = req.getParameter("description");
        boolean isError = false;
        if(taskTitle == null || taskTitle.isEmpty())
        {
            req.setAttribute("ErrorTitle", "Field Title is empty!");
            isError = true;
        }
        if(description == null || description.isEmpty())
        {
            req.setAttribute("ErrorDescription", "Field Description is empty!");
            isError = true;
        }
        if(!isError) {
            TaskService newTask = TaskService.INSTANCE;
            Task task = newTask.addTask(taskTitle, description);
            if(task !== null && !isError) {
                HttpSession session = req.getSession();
                session.setAttribute("task", task);
            }
            else {
                req.setAttribute("Error", "Such task is used");
                isError = true;
            }
        }
    }
}
