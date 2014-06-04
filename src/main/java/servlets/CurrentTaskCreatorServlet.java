package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by VLAD on 04.06.2014.
 */
@WebServlet("/creattask")
public class CurrentTaskCreatorServlet extends HttpServlet
{
    @Override
    public void init() throws ServletException {
        System.out.println("EmployerServlet is i");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String userName = req.getParameter("username");
        System.out.println("User Name: " + userName);
        req.getRequestDispatcher("/secretPages/employer.jsp").forward(req, resp);

    }
}
