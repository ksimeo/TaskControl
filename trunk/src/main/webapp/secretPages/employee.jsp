<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>


<html>
<script src="http://code.jquery.com/jquery-1.9.0.js"></script>
<script type="text/javascript" src="../../script/jquery.tablesorter.min.js"></script>
<link rel="stylesheet" type="text/css" href="../../content/style.css" />
<head>
    <title>${currentUser}</title>
    <link rel="shortcut icon" href="../img/favicon.ico" type="image/x-icon">
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
                    console.log("Date:" + servletResult.date + "State:" + servletResult.state);
                    document.getElementById('resultStart-' + currentTaskId).innerHTML = '<p>' + servletResult.date + '</p>';
                    document.getElementById("endTask-" + currentTaskId).style.display = "true";
                    document.getElementById('state-' + currentTaskId).innerHTML = servletResult.state;
                },
                error: function ()
                {
                    console.log('error');
                }
            });
    }
    function ajaxEndTask(currentTaskId)
    {
        console.log("currentTaskId:" +currentTaskId );
        if ( document.getElementById("startTask-" + currentTaskId) != null && document.getElementById("startTask-" + currentTaskId).style.display != "none")
        {
            document.getElementById("endTask-" + currentTaskId).style.display = "false";
        }
        else
        {

            document.getElementById("endTask-" + currentTaskId).style.display = "none";
            var paramData = "taskId=" + currentTaskId;
            $.ajax({
                type:'POST',
                url:'/secretPages/endTaskEmployee',
                data: paramData,
                success: function(servletResult)
                {
                    console.log("Date:" + servletResult.date + "State:" + servletResult.state);
                    document.getElementById('resultEnd-' + currentTaskId).innerHTML = '<p>' + servletResult.date + '</p>';
                    document.getElementById('state-' + currentTaskId).innerHTML = servletResult.state;
                },
                error: function ()
                {
                    console.log('error');
                }
            });
        }
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
    $(document).ready(function()
            {
                $("#allTasks").tablesorter( {sortList: [[0,0], [1,0]]} );
            }
    );
</script>

<table>
    <tr>
        <td >
            <p>
                <h2 style="margin-top: 35; margin-left: 25;">
                     ${currentUser}
                </h2>
            </p>

        </td>
    </tr>
    <tr>
        <td>
            <form action="/logout" method="post" style="margin-left: 25;">
                <input type="submit" value="LogOut"/>
            </form>
        </td>
    </tr>
</table>
<tr>
    <p align="center">
        <input type="button" value="&lt;--PREV" onclick="changePage(-1)">
        <input type="button" value="NEXT --&gt;" onclick="changePage(1)">
    </p>
    <h3 align="center">List all the tasks </h3>
</tr>
<div class="table-userdata">
    <table id="allTasks" class="tablesorter"style="border:3px solid black; border-collapse: collapse; margin-left: 50px;">
       <thead>
            <tr class="column-view" style="background-color: goldenrod">
                <th class="column-viewHeader">Creator</th>
                <th class="column-viewHeader">Date create</th>
                <th class="column-viewHeader">Title</th>
                <th class="column-viewHeader">Description</th>
                <th class="column-viewHeader">Priority</th>
                <th class="column-viewHeader">State</th>
                <th class="column-viewHeader">Start date</th>
                <th class="column-viewHeader">End date</th>
            </tr>
       </thead>
        <tbody>
             <c:forEach var="item" items="${allUserTasks}">
                 <tr class="column-view">
                     <td class="column-view">${item.creator.name}</td>
                     <td class="column-view">
                         <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.currentTask.createDate}"/>
                     </td>
                     <td class="column-view">${item.task.taskTitle}</td>
                     <td class="column-view">${item.task.description}</td>
                     <td class="column-view">${item.currentTask.priority}</td>

                     <td class="column-view">
                         <div id="state-${item.currentTask.id}">
                            ${item.currentTask.state}
                         </div>
                     </td>
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
                                 <input id = "endTask-${item.currentTask.id}" type="button" value="End" onclick="ajaxEndTask('${item.currentTask.id}')">
                             </c:if>

                             <c:if test="${not empty item.currentTask.endDate}">
                                 <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.currentTask.endDate}"/>
                             </c:if>
                         </div>
                     </td>
                 </tr>
             </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
