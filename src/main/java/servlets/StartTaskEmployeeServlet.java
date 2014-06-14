package servlets;

import helpers.CommonHelper;
import model.CurrentTask;
import service.CurrentTaskService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        try
        {
            CurrentTaskService startTask = CurrentTaskService.INSTANCE;
            int idTask = Integer.parseInt(req.getParameter("taskId"));
            CurrentTask ct = new CurrentTask(idTask);
            startTask.setStartDate(ct);
            resp.getWriter().println(CommonHelper.correctDateFormat(ct.getStartDate()));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
