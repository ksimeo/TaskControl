package servlets;

import com.amazonaws.util.json.JSONObject;
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
            resp.setContentType("application/json");
            CurrentTaskService startTask = CurrentTaskService.INSTANCE;
            int idTask = Integer.parseInt(req.getParameter("taskId"));
            CurrentTask ct = new CurrentTask(idTask);
            startTask.setStartDate(ct);
            startTask.setStateStart(ct);

            JSONObject obj = new JSONObject();
            obj.put("date", CommonHelper.correctDateFormat(ct.getStartDate()));
            obj.put("state", ct.getState());
            resp.getWriter().println(obj);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
