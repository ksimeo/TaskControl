<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ page isELIgnored="false" %>

<html>
<script type="text/javascript" src="../script/jquery-1.9.0.min.js"></script>
<%--<link rel="stylesheet" type="text/css" href="../resources/style.css" />--%>
<head>
    <title></title>
</head>
<body>
<form>
    <div>
        <table>
            <tr>
                <td colspan="2" style="text-align:center; ">
                    <h3 style="margin-left: 60; margin-bottom: 15;" > Registration </h3>
                </td>
                <td>

                </td>
            </tr>

            <tr>
                <td>
                    <p> <strong> Full name:</strong> </p>
                </td>
                <td>
                    <input type="text" name="fullName" value="${param.fullName}"/>
                </td>
            </tr>
            <tr>
                <td>
                    <p> <strong> Login:</strong> </p>
                </td>
                <td>
                    <input type="text" name="login" value="${param.login}"/>
                </td>
            </tr>
            <tr>
                <td>
                    <p> <strong> Password:</strong> </p>
                </td>
                <td>
                    <input type="password" name="password" value="${param.password}"/>
                </td>
            </tr>
            <tr>
            <td>
                <p> <strong> Confirm password:</strong> </p>
            </td>
            <td>
                <input type="password" name="confPassword" value="${param.confPassword}"/>
            </td>
            </tr>
            <tr>
                <td>
                    <p> <strong> User Role:</strong> </p>
                </td>
                <td>
                    <select name="role" size="1">
                        <option name="employer" value="${param.employer}">employer</option>
                        <option name="employee" value="${param.employee}">employee</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>

                </td>
                <td style="text-align: right;">
                    <input type="submit" value="Sign Up"/>
                   <%-- ${Error}--%>
                </td>
            </tr>
        </table>
    </div>

</form>
</body>
</html>
