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
        String taskTitle = req.getParameter("tasktitle");

        System.out.println("User Name: " + userName);
        System.out.println("Task Title: " + taskTitle);
        resp.sendRedirect("/secretPages/employer");

    }
}
