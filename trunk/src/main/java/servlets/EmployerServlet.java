package servlets;

import helpers.TaskHelper;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Avega on 02.06.14.
 */

@WebServlet(urlPatterns = "/secretPages/employer")
public class EmployerServlet extends HttpServlet
{
    @Override
    public void init() throws ServletException {


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        TaskHelper th = new TaskHelper();
        req.setAttribute("users", th.getAllEmployessNames());
        req.setAttribute("tasks", th.getAllTasksTitles());
        req.setAttribute("ctasks", th.ConvertToShow((List)req.getSession().getAttribute("newCurTasks")));
        HttpSession ses = req.getSession();
        User user = (User)ses.getAttribute("user");
        String name = user.getName();
        req.setAttribute("username", name);
        req.getRequestDispatcher("/secretPages/employer.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
    }
}
