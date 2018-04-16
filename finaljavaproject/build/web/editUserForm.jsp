<%-- 
    Document   : editUserForm
    Created on : 28-Mar-2018, 10:05:18 AM
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
            <h2>Edit user</h2>
            <form action="update" method="post" name="editForm">
                <input type="hidden" name="id" id="userId" value="${user.userId}"/>
                <table cellpadding="5" border="1">
                    <tr>
                        <th>first Name</th>
                        <td>
                            <input type="text" name="firstName" id="firstName" value="${user.firstName}">
                        </td>
                    </tr>
                    
                     <tr>
                        <th>last Name</th>
                        <td>
                            <input type="text" name="lastName" id="lastName" value="${user.lastName}">
                        </td>
                    </tr>
                     <tr>
                        <th>Phone No</th>
                        <td>
                            <input type="text" name="phoneNo" id="phoneNo" value="${user.phoneNo}">
                        </td>
                    </tr>
                    
                    <tr>
                        <th>email</th>
                        <td><input type="email" name="email" id="email" value="${user.email}"></td>
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
