package servlets;

import helpers.TaskHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by VLAD on 13.06.2014.
 */
@WebServlet(urlPatterns = "/description")
public class TaskDescription extends HttpServlet
{

    @Override
    public void init() throws ServletException
    {
        System.out.println("TaskDescription Servlet is inited");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        TaskHelper th = new TaskHelper();
        String descripText = th.getDescriptionByTitle(String title);
        String val = req.getParameter("title");
        System.out.println(val);
    }


}
