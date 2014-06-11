<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ page isELIgnored="false" %>

<html>
<script type="text/javascript" src="../script/jquery-1.9.0.min.js"></script>
<link rel="stylesheet" type="text/css" href="../content/style.css" />
<head>
    <title></title>
</head>
<body>
<form action="/authorization" method="post">
    <div  style="width: 100%; text-align: -webkit-center; margin-top: 200;">
        <table>
            <tr>
                <td colspan="2" style="text-align:-webkit-auto; ">
                    <h3 style="margin-left: 60; margin-bottom: 15;" > Authorization </h3>
                </td>
                <td>

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
                <td colspan="2" style="text-align:-webkit-auto; ">
                    <p style="color: red">
                        ${Error}
                    </p>
                </td>
                <td>

                </td>
            </tr>
            <tr>
                <td>

                </td>
                <td style="text-align: right;" >
                    <input type="submit" value="Sign In"/>
                </td>
            </tr>

            <tr>
                <td>
                </td>
                <td style="text-align: right;">
                    <a href = "/registration"><strong>Register new user</strong></a>
                </td>
            </tr>
        </table>
    </div>

</form>
</body>
</html>
