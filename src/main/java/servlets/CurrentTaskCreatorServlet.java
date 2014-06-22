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
public class CurrentTaskCreatorServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        TaskHelper th = new TaskHelper();
        String userName = req.getParameter("username");
        String taskTitle = req.getParameter("tasktitle");
        String priority = req.getParameter("priority");
        HttpSession session = req.getSession();
        User creator = (User) session.getAttribute("user");


        if (userName != null && taskTitle != null && priority != null && creator != null) {

            User recipient = th.getUserByFullName(userName);
            Task task = th.getTaskByTitle(taskTitle);



            CurrentTask newCurTask = th.saveCurrentTask(task.getId(), creator.getUserId(), recipient.getUserId(), priority);
            List<CurrentTask> newCurTasks = (List) session.getAttribute("newCurTasks");
            newCurTasks.add(newCurTask);
//            System.out.println(session.getAttribute("newCurTasks"));

            req.setAttribute("currenttasks", session.getAttribute("newCurTasks"));

        }
        //req.getRequestDispatcher("/secretPages/employer.jsp").forward(req, resp);
        resp.sendRedirect("/secretPages/employer");

    }
}
