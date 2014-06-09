package servlets;

import model.CurrentTask;
import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Avega on 02.06.14.
 */
@WebServlet(urlPatterns = "/authorization")
public class AuthServlet extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        try
        {
            String login = req.getParameter("login");
            String passw = req.getParameter("password");
            boolean isError = false;

            if (null == login || login.isEmpty())
            {
                req.setAttribute("ErrorLogin", "Field Login is empty!");
                isError = true;
            }
            if(null == passw || passw.isEmpty())
            {
                req.setAttribute("ErrorPassw", "Field Password is empty!");
                isError = true;
            }

            User usr = UserService.INSTANCE.checkLogin(login, passw);
            if(!isError && null != usr )
            {
                HttpSession session = req.getSession();

                session.setAttribute("user", usr);

                session.setMaxInactiveInterval(30*60);
                Cookie userLogin = new Cookie("user", login);
                userLogin.setMaxAge(30*60);
                resp.addCookie(userLogin);

            } else {
                req.setAttribute("Error", "You entered wrong password or login");
                isError = true;
            }

            if(isError)
            {
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
            }
            else
            {
                req.removeAttribute("ErrorLogin");
                req.removeAttribute("ErrorPassw");
                //req.getRequestDispatcher("/secretPages/employer.jsp").forward(req, resp);
                if(usr.getRole() == 1)
                {
                    resp.sendRedirect("/secretPages/employer");
                }
                else
                {
                    resp.sendRedirect("/secretPages/employee");
                }
            }

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

    }


}
