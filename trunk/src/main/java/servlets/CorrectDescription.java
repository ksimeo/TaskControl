package servlets;

import helpers.TaskHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by VLAD on 14.06.2014.
 */
@WebServlet("/correct")
public class CorrectDescription extends HttpServlet
{
    @Override
    public void init() throws ServletException { }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String description = req.getParameter("description");
        String title = req.getParameter("tasktitle");
        if(!description.equals("") && title != null)
        {
            TaskHelper th = new TaskHelper();
            th.setDescription(title, description);
        }
        System.out.println(title);
        resp.sendRedirect("/secretPages/employer");
    }
}
