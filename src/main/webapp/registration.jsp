<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ page isELIgnored="false" %>

<html>
<script type="text/javascript" src="../script/jquery-1.9.0.min.js"></script>
<link rel="stylesheet" type="text/css" href="../content/style.css" />
<head>
    <title>Registration</title>
    <link rel="shortcut icon" href="../img/favicon.ico" type="image/x-icon">
</head>
<body>
<form action="/registration" method="post">
    <div style="width: 100%; text-align: -webkit-center; margin-top: 200;">
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
                    </br>
                    <p style="color: red">
                        ${ErrorName}
                    </p>
                </td>
            </tr>
            <tr>
                <td>
                    <p> <strong> Login:</strong> </p>
                </td>
                <td>
                    <input type="text" name="login" value="${param.login}"/>
                    </br>
                    <p style="color: red">
                        ${ErrorLogin}
                    </p>
                </td>
            </tr>
            <tr>
                <td>
                    <p> <strong> Password:</strong> </p>
                </td>
                <td>
                    <input type="password" name="password" value="${param.password}"/>
                    </br>
                    <p style="color: red">
                        ${ErrorPassw}
                    </p>
                </td>
            </tr>
            <tr>
            <td>
                <p> <strong> Confirm password:</strong> </p>
            </td>
            <td>
                <input type="password" name="confPassword" value="${param.confPassword}"/>
                </br>
                <p style="color: red">
                    ${ErrorConfPassw}
                </p>
            </td>
            </tr>
            <tr>
                <td>
                    <p> <strong> User Role:</strong> </p>
                </td>
                <td>
                    <select name="role" size="1" >
                        <c:forEach items="${role}" var="item">
                            <option name="employer" value="${item.roleId}">${item.nameRole}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>

                </td>
                <td style="text-align: right;">
                    <input type="submit" value="Sign Up" />
                    </br>
                    <p style="color: red">
                    ${Error}
                    </p>
                </td>
            </tr>
        </table>
    </div>

</form>
</body>
</html>
