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
<form actiom="/userData" method="post">
<table>
    <tr>
        <td>
            ${user}
        </td>

    </tr>
</table>
<%--</form>
Employee
<form action="/logout" method="post">
    <input type="submit" value="LogOut"/>
</form>--%>
</body>
</html>
