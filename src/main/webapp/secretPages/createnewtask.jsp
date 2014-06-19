<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ page isELIgnored="false" %>

<html>
<script type="text/javascript" src="../script/jquery-1.9.0.min.js"></script>
<link rel="stylesheet" type="text/css" href="../content/style.css" />
<script type="text/javascript" src="../script/taskCreation.js"></script>
<head>
    <title>TaskControl v.1.0. Creation of new task</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="/img/favicon.png" type="image/x-icon">
</head>
<body>
<form action="/createnewtask" method="post">
    <div style="width: 730px; height: 77px; text-align: -webkit-center; margin: 0px auto; margin-top: 60px; background-color: #ededed;
     border: 1px solid #aaacb2; border-radius: 10px; padding: 1px 15px 1px 15px; font-family: sans-serif">
        <p><b>Creation of new task</b>
        <hr/></p>
    </div>
    <div style="width: 642px; text-align: -webkit-center; margin: 0px auto; margin-top: 5px; background-color: #ededed;
    border: 1px solid #aaacb2; border-radius: 10px; padding-left: 60px; padding-right: 60px; padding-top: 30px; font-family: sans-serif" >
        <h><b>Title of new task:</b>
        <input type="text" size="78" name="title" style="text-align:left; border-radius: 5; border: 1px solid #aaacb2;"/>
        <p style="text-align: left; padding-left: 1px;">
            <h><b>Description of task:</b></h>
            <textarea name="description" cols="77" rows="10" style="background-color: #fffa9e; resize: none; border-radius: 5;"></textarea>
        </p>
            <hr/>
            <p style="text-align: left">
        <input type="submit" value="&nbsp &nbsp Create &nbsp &nbsp"/>
        <input type="button" value="&nbsp &nbsp Cancel &nbsp &nbsp" onclick="TaskNotCreated()">
            </p>
        <p style="color: red">
            ${ErrorForm}
        </p>
        </div>
</form>
</body>
</html>