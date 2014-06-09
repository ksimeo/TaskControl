package servlets;

import dao.RoleDao;
import dao.UserDao;
import model.CurrentTask;
import model.Role;
import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/registration")
public class RegisterServlet extends HttpServlet
{


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {

        RoleDao rDao = new RoleDao();
        List<Role> role = rDao.getAllRole();
        req.setAttribute("role",role);
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
        boolean isError = false;
        if(null == name || name.isEmpty())
        {
            req.setAttribute("ErrorName", "Field Full name is empty!");
            isError = true;
        }
        if (null == login || login.isEmpty())
        {
            req.setAttribute("ErrorLogin", "Field Login is empty!");
            isError = true;
        }
        if(null == password || password.isEmpty())
        {
            req.setAttribute("ErrorPassw", "Field Password is empty!");
            isError = true;
        }
        if(null == confPassword || confPassword.isEmpty())
        {
            req.setAttribute("ErrorConfPassw", "Field Password is empty!");
            isError = true;
        }
        if (confPassword.equals(password) && !isError && !confPassword.isEmpty() && !password.isEmpty())
        {
            UserService saveUs = UserService.INSTANCE;
            User user = saveUs.saveUser(name, login, password, rolenum);
            if(user != null && !isError)
            {
                HttpSession session = req.getSession();

                session.setAttribute("user", user);
                List<CurrentTask> newCurTasks = new ArrayList<>();
                session.setAttribute("newCurTasks", newCurTasks);

                session.setMaxInactiveInterval(30*60);
                Cookie userLogin = new Cookie("user", login);
                userLogin.setMaxAge(30*60);
                resp.addCookie(userLogin);
                if(user.getRole() == 1)
                {
                    resp.sendRedirect("/secretPages/employer");
                }
                else
                {
                    resp.sendRedirect("/secretPages/employee");
                }
            }
            else
            {
                req.setAttribute("Error", "Such login is used");
                isError = true;
            }

        }


        if(isError)
        {
            RoleDao rDao = new RoleDao();
            List<Role> role2 = rDao.getAllRole();
            req.setAttribute("role",role2);
            req.getRequestDispatcher("/registration.jsp").forward(req, resp);
        }

    }
}
