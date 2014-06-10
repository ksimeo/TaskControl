<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ page isELIgnored="false" %>

<html>
<form action="/createnewtask" method="post">
    <script type="text/javascript" src="../script/jquery-1.9.0.min.js"></script>
    <head lang="en">
        <meta charset="UTF-8">
        <title>Creation of new task</title>
    </head>
    <body>
    <p><h1>Creation of new task</h1></p>
    <p>Fill all input field of new task, please!</p>
    <h><b>Title of new task:</b></h><input type="text" size="32" name="title" value="${param.title}"/>
    </br>
    <p style="color: red">
        ${ErrorTitle}
    </p>
    <p><b>Description of task:</b><Br>
        <textarea name="description" cols="40" rows="10" value="${param.description}></textarea></p>
    </br>
    <p style="color: red">
${ErrorDescription}
    </body>
</form>
</html>