package servlets;

import com.sun.org.apache.bcel.internal.generic.Select;
import helpers.TaskHelper;
import model.User;
import service.IUserService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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
        req.setAttribute("users", th.getAllUsarsNames());
        req.setAttribute("tasks", th.getAllTasksTitles());

        req.getRequestDispatcher("/secretPages/employer.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
    }
}
