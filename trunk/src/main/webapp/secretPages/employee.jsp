<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ page isELIgnored="false" %>


<html>
<script src="http://code.jquery.com/jquery-1.9.0.js"></script>
<link rel="stylesheet" type="text/css" href="../../content/style.css" />
<head>
    <title></title>
</head>
<body>
<script type="text/javascript">

    function ajaxStartTask(currentTaskId)
    {

            document.getElementById("startTask-" + currentTaskId).style.display = "none";
            var paramData = "taskId=" + currentTaskId;
            $.ajax({
                type:'POST',
                url:'/secretPages/startTaskEmployee',
                data: paramData,
                success: function(servletResult)
                {
                    document.getElementById('query-result').innerHTML = servletResult;
                        console.log(servletResult);
                },
                error: function ()
                {
                    console.log('error');
                }

            });
    }

</script>

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
<div class="table-userdata">
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
                 <td class="column-view">${item.creator.name}</td>
                 <td class="column-view">${item.currentTask.createDate}</td>
                 <td class="column-view">${item.task.taskTitle}</td>
                 <td class="column-view">${item.task.description}</td>
                 <td class="column-view">${item.currentTask.priority}</td>
                 <td class="column-view" >
                     <div id="query-result">
                         <c:if test="${empty item.currentTask.startDate}">
                                 <input id = "startTask-${item.currentTask.id}" type="button" value="Start" onclick="ajaxStartTask(${item.currentTask.id})">
                         </c:if>

                         <c:if test="${not empty item.currentTask.startDate}">
                             ${item.currentTask.startDate}
                         </c:if>

                     </div>
                 </td>

                 <td class="column-view" >
                     <input type="button" value="End" onclick="">
                     ${item.currentTask.endDate}
                 </td>
             </tr>
         </c:forEach>
        <tr>
            <p align="center">
                <input type="button" value="&lt;--PREV" onclick="history.go(-1)">
                <input type="button" value="NEXT --&gt;" onclick="history.go(1)">
            </p>
        </tr>
    </table>
</div>

<form action="/logout" method="post">
    <input type="submit" value="LogOut"/>
</form>
</body>
</html>
