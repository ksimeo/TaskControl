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

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String name = req.getParameter("fullName");
        String login = req.getParameter("AddLogin");
        String password = req.getParameter("AddPassword");
        String confPassword = req.getParameter("AddConfPass");
        String role = req.getParameter("AddRole");
        int rolenum = role != null ? Integer.parseInt(role) : 0;

        if (confPassword.equals(password))
        {
            UserService saveUs = UserService.INSTANCE;
            saveUs.saveUser(name, login,password,rolenum);
        }
        else
        {
            req.getRequestDispatcher("/registration.jsp").forward(req, resp);

        }


    }
}
