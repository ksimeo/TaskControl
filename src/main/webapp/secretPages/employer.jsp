<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ page isELIgnored="false" %>

<html>
<script type="text/javascript" src="../script/jquery-1.9.0.min.js"></script>
<head>
    <title></title>
</head>
<body>
Employer

</body>



<form action="/logout" method="post">
    <input type="submit" value="LogOut"/>
</form>



<form name = creatTask method="post" action="/creattask">
    <select size="5" name="username" selected=${param.username}>
        <%!
            Iterator iter;
            List users;
            int i = 0;
        %>
        <%
            users = (List)request.getAttribute("users");
            iter = users.iterator();

            while (iter.hasNext())
            {
                String tmp = (String)iter.next();
        %>
                <option value="<%= tmp%>"> <%= tmp%> </option>

        <%
                i++;
            }
        %>

    </select>
    <input type="submit" value="Creat">
</form>
</html>
