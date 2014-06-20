<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ page isELIgnored="false" %>

<html>
<link rel="stylesheet" type="text/css" href="../content/styles.css" />
<script type="text/javascript" src="../script/taskCreation.js"></script>
<head>
    <title>Creation of new task - TaskControl 1.0</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="shortcut icon" href="../img/favicon.ico" type="image/x-icon">
</head>
<body>
<form action="/createnewtask" method="post">
    <div id="plank1">
        <p><b>Creation of new task</b>
        <hr/></p>
    </div>
    <div id="plank2">
        <h><b>Title of new task:</b></h>
            <input type="text" size="78" name="title" id="textString"/>
            <p style="text-align: left; padding-left: 2px;">
                <h><b>Description of task:</b></h>
                <textarea name="description" cols="77" rows="10" id="textwindow"></textarea>
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