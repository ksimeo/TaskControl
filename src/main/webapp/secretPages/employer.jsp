<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="model.CurrentTask" %>
<%@ page import="java.util.Objects" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ page isELIgnored="false" %>

<html>

<script type="text/javascript" src="../script/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="../script/taskDescription.js"></script>
<link rel="stylesheet" type="text/css" href="../../content/style.css"/>

<head>
    <title>Task creator - TaskControl 1.0</title>
    <link rel="shortcut icon" href="../img/favicon.ico" type="image/x-icon">
</head>

<body>
<table align="center" border="0">
    <tr>
        <td>
            <div class="div-content" style="margin-top: 50px">
                <table border="0">
                    <tr>
                        <td>
                            <form action="/logout" method="post">
                                <b>Employer</b>
                                <br/>
                                <%= request.getAttribute("username")%>
                                <input type="submit" value="LogOut"/>
                                <br/>
                            </form>
                        </td>
                    </tr>
                </table>
            </div>

            <div class="div-content">
                <form name=creatTask method="post" action="/creattask">


                    </select>


                    <table border="0" align="center" style="font-family: sans-serif">
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
                                <select size="10" id="tasktitle" name="tasktitle">


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
                                    <textarea class="textarea"  id="ansver" name="description" rows="10" cols="60" style="resize: none"></textarea>
                                </form>
                            </td>

                        </tr>

                        <tr>
                            <td colspan="3" align="right"><input type="submit" value="Create"></td>
                            <td align="right"><input type="submit" value="Correct" formaction="/correct"
                                                     formmethod="post"/></td>

                        </tr>

                        <tr>
                            <td colspan="4">
                                <hr/>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <input type="button" value="All tasks" onclick="pressButtonAllTasks()">
                                <input type="button" value="Create task" onclick="CreateTask()">
                            </td>


                        </tr>
                    </table>
                </form>
            </div>

            <div class="div-content">
                <center><b>New current tasks</b></center>
                <hr/>

                <%
                    List<CurrentTask> newCurTasks = (List) request.getAttribute("ctasks");
                    iter = newCurTasks.iterator();
                    while (iter.hasNext()) {

                %>

                    <%= iter.next()%>
                    <br/>
                <%
                    }
                %>

            </div>
        </td>
    </tr>
</table>
</body>
</html>
