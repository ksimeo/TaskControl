<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>


<html>
<script src="http://code.jquery.com/jquery-1.9.0.js"></script>
<link rel="stylesheet" type="text/css" href="../../content/style.css" />
<%--<script type="text/javascript" src="../../script/jquery-latest.js"></script>--%>
<script type="text/javascript" src="../../script/jquery.tablesorter.min.js"></script>
<head>
    <title>All tasks - TaskControl 1.0</title>
    <link rel="shortcut icon" href="../img/favicon.ico" type="image/x-icon">
</head>
<script type="text/javascript">
    var currentPage = ${page};
    function changePage(increment)
    {
        var tmp = currentPage + increment;
        if(tmp >= 0)
        {
            currentPage += increment;
            document.location ="/secretPages/allTasks?page="+ currentPage;
        }
    }
    function pressButtonEmployer() {
        document.location = "/secretPages/employer";
    }
    $(document).ready(function()
            {
                $("#tableAllTasks").tablesorter( {sortList: [[0,0], [1,0]]} );
            }
    );

</script>
<body>
<tr>
    <td>
    <input type="button" value="&lt;--PAGE EMPLOYER" onclick="pressButtonEmployer()"  style="margin-top: 35; margin-left: 50;">
    </td>
</tr>
<tr>
    <p align="center">
        <input type="button" value="&lt;--PREV" onclick="changePage(-1)">
        <input type="button" value="NEXT --&gt;" onclick="changePage(1)">
    </p>
    <h3 align="center">List all the tasks </h3>
</tr>
<div class="table-userdata">

        <%--<tr class="column-view">
            <th colspan="9" style="text-align: center; border: 3px solid;">
                <h3>List all the tasks </h3>
            </th>
        </tr>--%>

    <table id="tableAllTasks" class="tablesorter" style="border:3px solid black; border-collapse: collapse; margin-left: 50px;">
        <thead>
            <tr class="column-view" style="background-color: goldenrod">
                <th class="column-viewHeader">Creator</th>
                <th class="column-viewHeader">Recipient</th>
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
                    <td class="column-view">${item.recipient.name}</td>
                    <td class="column-view">
                        <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.currentTask.createDate}"/>
                    </td>
                    <td class="column-view">${item.task.taskTitle}</td>
                    <td class="column-view">${item.task.description}</td>
                    <td class="column-view">${item.currentTask.priority}</td>
                    <td class="column-view">${item.currentTask.state}</td>
                    <td class="column-view">
                        <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.currentTask.startDate}"/>
                    </td>
                    <td class="column-view">
                        <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.currentTask.endDate}"/>
                    </td>
                </tr>
            </c:forEach>
         </tbody>
    </table>
</div>
</body>
</html>

