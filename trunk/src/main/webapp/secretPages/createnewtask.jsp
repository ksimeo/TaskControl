<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ page isELIgnored="false" %>

<html>
<link rel="stylesheet" type="text/css" href="../content/style.css" />
<head>
    <title>Creation of new task</title>
</head>
<body>
<form action="/createnewtask" method="post">
    <div>
        <p><h1>Creation of new task</h1></p>
        <h><b>Title of new task:</b></h>
        <input type="text" size="32" name="title" style="text-align:left;" value=""/>
        <p>
            <b>Description of task:</b>
            <br/>
            <textarea name="description" cols="40" rows="10"></textarea>
        </p>
        <input type="submit" value="Create"/>
        <p style="color: red">
            ${ErrorForm}
        </p>
    </div>
</form>
</body>
</html>