package servlets;

import model.CurrentTask;
import service.CurrentTaskService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Avega on 12.06.14.
 */
@WebServlet(urlPatterns = "/secretPages/startTaskEmployee")
public class StartTaskEmployeeServlet extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        CurrentTaskService startTask = CurrentTaskService.INSTANCE;
        int idTask = Integer.parseInt(req.getParameter("taskId"));
        CurrentTask ct = new CurrentTask(idTask);
        startTask.setStartDate(ct);
        resp.getWriter().println(ct.getStartDate());
    }
}
