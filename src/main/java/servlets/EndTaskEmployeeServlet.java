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

/**
 * Created by Avega on 14.06.14.
 */
@WebServlet(urlPatterns = "/secretPages/endTaskEmployee")
public class EndTaskEmployeeServlet extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CurrentTaskService endTask = CurrentTaskService.INSTANCE;
        int idTask = Integer.parseInt(req.getParameter("taskId"));
        CurrentTask ct = new CurrentTask(idTask);
        endTask.setEndDate(ct);
        resp.getWriter().println(CommonHelper.correctDateFormat(ct.getEndDate()));
    }
}
