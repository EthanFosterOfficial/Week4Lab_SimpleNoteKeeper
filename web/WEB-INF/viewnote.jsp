<%-- 
    Document   : viewnote
    Created on : Sep 28, 2020, 4:23:13 PM
    Author     : 727045
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Note Keeper E.F</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>

        <strong>Title: </strong> ${title}<br> <br>
        <strong> Contents: </strong> ${content}<br>
        <br>
        <a href="note?edit">Edit</a>


    </body>
</html>
