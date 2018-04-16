<%-- 
    Document   : register
    Created on : 28-Mar-2018, 10:06:06 AM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <center>
          
            <a href="list">View Users</a>
        </center>
        <center>
            <h2>Register new user</h2>
            <form action="insert" method="post" name="registerForm">
                <table cellpadding="5" border="1">
                    <tr>
                        <th>First Name</th>
                        <td><input type="text" name="firstName" id="firstName"></td>
                    </tr>
                    <tr>
                        <th>last Name</th>
                        <td><input type="text" name="lastName" id="lastName"></td>
                    </tr>
                    <tr>
                        <th>Phone NO</th>
                        <td><input type="text" name="phoneNo" id="phoneNo"></td>
                    </tr>
                    <tr>
                        <th>Email</th>
                        <td><input type="email" name="email" id="email"></td>
                    </tr>
                   
                    <tr>
                        <td colspan="2"><input type="submit" name="submit" value="Save"></td>
                    </tr>
                </table>
               <!-- <input type="submit" name="submit" value="view">-->
            </form>
        </center>
    </body>
</html>
