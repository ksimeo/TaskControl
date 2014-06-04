package servlets;

import dao.UserDao;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/registration")
public class RegisterServlet extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {

        req.getRequestDispatcher("/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String name = req.getParameter("fullName");

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String confPassword = req.getParameter("confPassword");
        String role = req.getParameter("role");
        int rolenum = role != null ? Integer.parseInt(role) : 0;




        if (confPassword.equals(password))
        {
            UserService saveUs = UserService.INSTANCE;
            saveUs.saveUser(name, login, password, rolenum);
        }
        else
        {
            req.getRequestDispatcher("/registration.jsp").forward(req, resp);

        }



    }
}
