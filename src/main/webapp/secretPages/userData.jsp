<%--
  Created by IntelliJ IDEA.
  User: Avega
  Date: 21.05.14
  Time: 23:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ page isELIgnored="false" %>
<div id="table-userdata">
    <table style="border:3px solid black; border-collapse: collapse; margin-left: 50px;">
        <tr>
        <tr class="column-view"><td colspan="7" style="text-align: center; border: 3px solid;"><h3>List all the tasks </h3></td></tr>
        </tr>
        <tr class="column-view" style="background-color:lavenderblush;">
            <td class="column-view">Creator</td>
            <td class="column-view">Date create</td>
            <td class="column-view">Title</td>
            <td class="column-view">Description</td>
            <td class="column-view">Priority</td>
            <td class="column-view">Start date</td>
            <td class="column-view">End date</td>
        </tr>
       <%-- <c:forEach var="item" items="${}">
            <tr class="column-view">
                <td class="column-view">${item.}</td>
                <td class="column-view">${item.}</td>
                <td class="column-view">${item.}</td>
                <td class="column-view">${item.}</td>
                <td class="column-view">${item.}</td>
                <td class="column-view">${item.}</td>
            </tr>
        </c:forEach>--%>
    </table>
</div>