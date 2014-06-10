<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ page isELIgnored="false" %>


<html>
<script type="text/javascript" src="../script/jquery-1.9.0.min.js"></script>
<link rel="stylesheet" type="text/css" href="../../secretPages/style.css" />
<head>
    <title></title>
</head>
<body>

<table>
    <tr>
        <td>
            <p>
                <h2>
                     ${currentUser}
                </h2>
            </p>

        </td>
    </tr>
</table>
<div id="table-userdata">
    <table style="border:3px solid black; border-collapse: collapse; margin-left: 50px;">
        <tr>
        <tr class="column-view"><td colspan="7" style="text-align: center; border: 3px solid;"><h3>List all the tasks </h3></td></tr>
        </tr>
        <tr class="column-view" style="background-color: goldenrod">
            <td class="column-view">Creator</td>
            <td class="column-view">Date create</td>
            <td class="column-view">Title</td>
            <td class="column-view">Description</td>
            <td class="column-view">Priority</td>
            <td class="column-view">Start date</td>
            <td class="column-view">End date</td>
        </tr>
         <c:forEach var="item" items="${allUserTasks}">
             <tr class="column-view">
                 <td class="column-view">${item.currentTask.creatorId}</td>
                 <td class="column-view">${item.currentTask.createDate}</td>
                 <td class="column-view">${item.task.taskTitle}</td>
                 <td class="column-view">${item.task.description}</td>
                 <td class="column-view">${item.currentTask.priority}</td>
                 <td class="column-view">${item.currentTask.startDate}</td>
                 <td class="column-view">${item.currentTask.endDate}</td>
             </tr>
         </c:forEach>
    </table>
</div>

<form action="/logout" method="post">
    <input type="submit" value="LogOut"/>
</form>
</body>
</html>
