<%-- 
    Document   : home
    Created on : Oct 16, 2021, 1:26:33 PM
    Author     : @bellaegenti1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login page</h1>

        <form method="post" action="login">

            <label>Username:</label>
            <input type="text"  name="username" value="${username}" required></input>
            <br>
            <br>
            <label>Password:</label>
            <input type="password" name="password" value="${password}"  required >
            <br>
            <br>
            <input type="submit" value="login">


            <p> ${errorMessage}</p>

            <p>${logoutMessage}</p>
        </form>


    </body>
</html>