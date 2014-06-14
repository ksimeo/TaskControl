package servlets;

import model.CommonTaskTable;
import model.CurrentTask;
import model.Task;
import model.User;
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
 * Created by Avega on 14.06.14.
 */
@WebServlet(urlPatterns = "/secretPages/allTasks")
public class AllTasksServlet extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        /*HttpSession session = req.getSession();*/
        /*User sessionUserAttr = (User)session.getAttribute("user");*/

        /*req.setAttribute("currentUser", sessionUserAttr.getName());*/
        List<CurrentTask> allTasks = CurrentTaskService.INSTANCE.getAllCurrentTasks();
        List<CommonTaskTable> comTaskTab = new ArrayList<CommonTaskTable>();
        for(CurrentTask item : allTasks)
        {
            Task t = TaskService.INSTANCE.getTaskById(item.getTaskId());
            User creator = UserService.INSTANCE.getUserById(item.getCreatorId());
            User recipient = UserService.INSTANCE.getUserById(item.getRecepientId());
            CommonTaskTable commonTaskTable = new CommonTaskTable(item, t, creator, recipient);
            comTaskTab.add(commonTaskTable);
        }

        req.setAttribute("allUserTasks", comTaskTab);


        req.getRequestDispatcher("/secretPages/alltasks.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        super.doPost(req, resp);
    }
}
