<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ page isELIgnored="false" %>

<html>
<script type="text/javascript" src="../script/jquery-1.9.0.min.js"></script>
<link rel="stylesheet" type="text/css" href="../content/style.css" />
<head>
    <title>Creation of new task</title>
</head>
<body>
<form action="/createnewtask" method="post">
    <div style="width: 1120px; text-align: -webkit-center; margin: 0px auto; margin-top: 50px; background-color: #ededed;
     border: 1px solid #aaacb2; border-radius: 10px; padding: 1px 15px 1px 15px; font-family: sans-serif">
        <p><h1>Creation of new task</h1>
        <hr/></p>
    </div>
    <div style="width: 1120px; text-align: -webkit-center; margin: 0px auto; margin-top: 15px; background-color: #ededed;
     border: 1px solid #aaacb2; border-radius: 10px; padding: 30px 15px 15px 15px; font-family: sans-serif" >
        <h><b>Title of new task:</b>
        <input type="text" size="148" name="title" style="text-align:left;" value=""/>
        <p style="padding: 20px 1px 1px 1px;">
            <h><b>Description of task:  &nbsp  &nbsp  &nbsp  &nbsp  &nbsp  &nbsp  &nbsp  &nbsp &nbsp &nbsp &nbsp &nbsp
                &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
                &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
                &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
                &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
                &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
                &nbsp</b></h>
            <br/>
            <textarea name="description" cols="130" rows="15"></textarea>
        </p>
            <hr/>
        <input type="submit" value="&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp Create &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp"/>
            <a href="employer"> Back to previous page </a>
        <p style="color: red">
            ${ErrorForm}
        </p>
    <%--</div>--%>
        </div>
</form>
</body>
</html>