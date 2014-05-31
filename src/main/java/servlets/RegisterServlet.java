package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/auth/registration")
public class RegisterServlet extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String fullName = req.getParameter("AddName");
        String login = req.getParameter("AddLogin");
        String password = req.getParameter("AddPassword");
        String confPassword = req.getParameter("AddConfPass");
        String role = req.getParameter("AddRole");

    }
}
