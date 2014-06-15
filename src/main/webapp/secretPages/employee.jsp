<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>


<html>
<script src="http://code.jquery.com/jquery-1.9.0.js"></script>
<link rel="stylesheet" type="text/css" href="../../content/style.css" />
<head>
    <title></title>
</head>
<body>
<script type="text/javascript">

    var currentPage = ${page};

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
                    document.getElementById('resultStart-' + currentTaskId).innerHTML = '<p>' + servletResult + '</p>';
                        console.log(servletResult);
                },
                error: function ()
                {
                    console.log('error');
                }
            });
    }
    function ajaxEndTask(currentTaskId)
    {
        document.getElementById("endTask-" + currentTaskId).style.display = "none";
        var paramData = "taskId=" + currentTaskId;
        $.ajax({
            type:'POST',
            url:'/secretPages/endTaskEmployee',
            data: paramData,
            success: function(servletResult)
            {
                document.getElementById('resultEnd-' + currentTaskId).innerHTML = '<p>' + servletResult + '</p>';
                console.log(servletResult);
            },
            error: function ()
            {
                console.log('error');
            }
        });
    }
    function changePage(increment)
    {
       var tmp = currentPage + increment;
       if(tmp >= 0)
       {
           currentPage += increment;
           document.location ="/secretPages/employee?page="+ currentPage;
       }

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
                 <td class="column-view">
                     <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.currentTask.createDate}"/>
                 </td>
                 <td class="column-view">${item.task.taskTitle}</td>
                 <td class="column-view">${item.task.description}</td>
                 <td class="column-view">${item.currentTask.priority}</td>
                 <td class="column-view" >
                     <div id="resultStart-${item.currentTask.id}">
                         <c:if test="${empty item.currentTask.startDate}">
                                 <input id = "startTask-${item.currentTask.id}" type="button" value="Start" onclick="ajaxStartTask(${item.currentTask.id})">
                         </c:if>

                         <c:if test="${not empty item.currentTask.startDate}">
                             <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.currentTask.startDate}"/>
                         </c:if>

                     </div>
                 </td>

                 <td class="column-view" >
                     <div id="resultEnd-${item.currentTask.id}">
                         <c:if test="${empty item.currentTask.endDate}">
                             <input id = "endTask-${item.currentTask.id}" type="button" value="End" onclick="ajaxEndTask(${item.currentTask.id})">
                         </c:if>

                         <c:if test="${not empty item.currentTask.endDate}">
                             <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.currentTask.endDate}"/>
                         </c:if>
                     </div>
                 </td>
             </tr>
         </c:forEach>
        <tr>
            <p align="center">
                <input type="button" value="&lt;--PREV" onclick="changePage(-1)">
                <input type="button" value="NEXT --&gt;" onclick="changePage(1)">
            </p>
        </tr>
    </table>
</div>

<form action="/logout" method="post">
    <input type="submit" value="LogOut"/>
</form>
</body>
</html>
