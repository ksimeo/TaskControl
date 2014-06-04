package servlets;

import helpers.TaskHelper;
import model.CurrentTask;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by VLAD on 04.06.2014.
 */
@WebServlet("/creattask")
public class CurrentTaskCreatorServlet extends HttpServlet
{
    @Override
    public void init() throws ServletException {
        System.out.println("EmployerServlet is i");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        TaskHelper th = new TaskHelper();
        String userName = req.getParameter("username");
        String taskTitle = req.getParameter("tasktitle");
        HttpSession session = req.getSession();
        User creator = (User)session.getAttribute("user");
        User toSave = th.getUserByFullName(userName);
        System.out.println("Creator's id: " + creator.getUserId());
        System.out.println("User Name: " + userName);
        System.out.println("User Id: " + toSave.getUserId());
        System.out.println("Task Title: " + taskTitle);
        System.out.println("Task Id: " + th.getTaskByTitle(taskTitle).getId());
        resp.sendRedirect("/secretPages/employer");
        //th.saveCurrentTask(th.getTaskByTitle(taskTitle).getId(), creator.getUserId(),toSave.getUserId(), CurrentTask.STATUS_IN_PROCESS,CurrentTask.PRIORITY_HEIGHT);

    }
}
