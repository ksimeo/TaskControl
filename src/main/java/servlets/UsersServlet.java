package servlets;

import model.CurrentTask;
import model.User;
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

@WebServlet(urlPatterns = "/secretPages/userData.jsp")
public class UsersServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String name = req.getParameter("fullName");
        UserService usName = UserService.INSTANCE;
        User user = usName.searchUser(name);
        HttpSession session = req.getSession();

        session.setAttribute("user", user.getName());
        List<CurrentTask> newCurTasks = new ArrayList<>();
        session.setAttribute("newCurTasks", newCurTasks);
    }
}
