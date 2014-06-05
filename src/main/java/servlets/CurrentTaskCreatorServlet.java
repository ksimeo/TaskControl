package servlets;

import helpers.TaskHelper;
import model.CurrentTask;
import model.Task;
import model.User;

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
        User recipient = th.getUserByFullName(userName);

        String taskTitle = req.getParameter("tasktitle");
        Task task = th.getTaskByTitle(taskTitle);

        String priority = req.getParameter("priority");
        HttpSession session = req.getSession();

        User creator = (User)session.getAttribute("user");


        System.out.println("-----------------------------");
        System.out.println("Task Id: " + task.getId() + "Task Title: " + taskTitle);
        System.out.println("Creator's id: " + creator.getUserId() + "Creator name: " + creator.getName());
        System.out.println("User Id: " + recipient.getUserId() + "User Name: " + userName);
        System.out.println("Priority: " + priority);
        System.out.println("-----------------------------");

        CurrentTask newCurTask = th.saveCurrentTask(task.getId(), creator.getUserId(), recipient.getUserId(), priority);
        List<CurrentTask> newCurTasks = (List)session.getAttribute("newCurTasks");
        newCurTasks.add(newCurTask);
        System.out.println(session.getAttribute("newCurTasks"));

        req.setAttribute("currenttasks", session.getAttribute("newCurTasks"));
        //req.getRequestDispatcher("/secretPages/employer.jsp").forward(req, resp);
        resp.sendRedirect("/secretPages/employer");

    }
}
