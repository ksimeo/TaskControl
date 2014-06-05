<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
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


<form action="/logout" method="post">
    <input type="submit" value="LogOut"/>
</form>

<hr/>
<form name=creatTask method="post" action="/creattask">


    </select>


    <table border="0">
        <tr align="center">
            <td><b>Workers</b></td>
            <td><b>Tasks titles</b></td>
            <td><b>Priority</b></td>
            <td><b>Tasks description</b></td>
        </tr>
        <tr>
            <td>
                <select size="10" name="username">

                        <%
            Iterator iter;
            List users;
            users = (List)request.getAttribute("users");
            iter = users.iterator();

            while (iter.hasNext())
            {
                String tmp = (String)iter.next();
        %>
                    <option value="<%= tmp%>"><%= tmp%>
                    </option>

                        <%

            }
        %>
            </td>
            <td>
                <select size="10" name="tasktitle">


                        <%
            List tasks;
            tasks = (List)request.getAttribute("tasks");
            iter = tasks.iterator();

            while (iter.hasNext())
            {
                String tmp = (String)iter.next();
        %>
                    <option value="<%= tmp%>"><%= tmp%>
                    </option>

                        <%
            }
        %>
            </td>
            <td>
                <select size="10" name="priority">
                    <option value="LOW">LOW</option>
                    <option value="MIDDLE">MIDDLE</option>
                    <option value="HEIGHT">HEIGHT</option>
                </select>
            </td>
            <td>
                <form name="description">
                    <textarea rows="10" cols="60" style="font-family: sans-serif"></textarea>
                </form>
            </td>

        </tr>

        <tr>
            <td><input type="submit" value="Creat"></td>
        </tr>
        <tr>
            <td>

            </td>
        </tr>
    </table>
</form>
<hr/>
<%
    List newCurTasks = (List)request.getAttribute("ctasks");
    iter = newCurTasks.iterator();
    while (iter.hasNext())
    {
%>
        <%= iter.next()%>
        <br/>
<%
    }
%>

</body>
</html>
