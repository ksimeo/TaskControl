package servlets;

import model.*;
import service.CurrentTaskService;
import service.TaskService;
import service.UserService;

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
 * Created by Avega on 02.06.14.
 */
@WebServlet(urlPatterns = "/secretPages/employee")
public class EmployeeServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        try
        {
        HttpSession session = req.getSession();
        User sessionUserAttr = (User)session.getAttribute("user");
        int page = Integer.parseInt(req.getParameter("page"));
        Parcel<CurrentTask> parcel = CurrentTaskService.INSTANCE.getCurrentTaskPage(sessionUserAttr, page);

        req.setAttribute("currentUser", sessionUserAttr.getName());
        List<CurrentTask> allTasks = parcel.getPage();
        List<CommonTaskTable> comTaskTab = new ArrayList<CommonTaskTable>();
        for(CurrentTask item : allTasks)
        {
            Task t = TaskService.INSTANCE.getTaskById(item.getTaskId());
            User u = UserService.INSTANCE.getUserById(item.getCreatorId());
            CommonTaskTable commonTaskTable = new CommonTaskTable(item, t, u);
            comTaskTab.add(commonTaskTable);
        }

        req.setAttribute("allUserTasks", comTaskTab);
        req.setAttribute("page", page);

        req.getRequestDispatcher("/secretPages/employee.jsp").forward(req, resp);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {

    }
}
