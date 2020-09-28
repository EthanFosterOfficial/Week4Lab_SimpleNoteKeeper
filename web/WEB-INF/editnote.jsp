<%-- 
    Document   : editnote
    Created on : Sep 28, 2020, 4:23:24 PM
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
        <h2>Edit Note</h2>
        <form action="post">
            Title: <input type="text" name="title" value="${title}"><br>
            Contents: <textarea id="content" name="content">"${content}"</textarea><br>
            
            <input type="submit" value="Save">
        </form>
        
        
        
    </body>
</html>
