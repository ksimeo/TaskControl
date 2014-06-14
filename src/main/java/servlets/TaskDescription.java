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

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        TaskHelper th = new TaskHelper();
        String descripText = "";
        String val = req.getParameter("title");

        if(val != null) {
            descripText = th.getDescriptionByTitle(val);
        }
        resp.getWriter().write(descripText);

    }


}
