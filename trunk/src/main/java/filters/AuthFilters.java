package filters;

import model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Avega on 02.06.14.
 */
@WebFilter(urlPatterns = "/*")
public class AuthFilters implements Filter
{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
    {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        HttpSession session = req.getSession(false);
        String uri = req.getRequestURI();
        Cookie[] cookies = req.getCookies();

        boolean isLoggedIn = false;

        User sessionUserAttr = null;

        if(session != null && cookies != null)
        {
            for(Cookie cookie: cookies)
            {
                if(cookie.getName().equals("user"))
                {
                    sessionUserAttr = (User)session.getAttribute("user");

                    if(null == sessionUserAttr)
                        break;

                    isLoggedIn = cookie.getValue().equalsIgnoreCase(sessionUserAttr.getLogin());
                    break;
                }

            }

        }
        if(!isLoggedIn && !(uri.endsWith("/index.jsp") || uri.endsWith("authorization") || uri.endsWith("registration")))
        {
            resp.sendRedirect("/index.jsp");
        }else{
            if(null != sessionUserAttr)
            {
                if(uri.endsWith("/logout"))
                {
                    filterChain.doFilter(servletRequest, servletResponse);
                }
                else if(sessionUserAttr.getRole() == 1 && ! (uri.endsWith("employer") || uri.endsWith("employer.jsp") )) //if employer
                {
                    resp.sendRedirect("/secretPages/employer");
                }
                else if (sessionUserAttr.getRole() == 2 && !( uri.endsWith("employee") || uri.endsWith("employee.jsp")))
                {
                    resp.sendRedirect("/secretPages/employee");
                }
                else
                {
                    filterChain.doFilter(servletRequest, servletResponse);
                }
            }
            else
            {

            filterChain.doFilter(servletRequest, servletResponse);
            }
        }

    }

    @Override
    public void destroy()
    {

    }
}
