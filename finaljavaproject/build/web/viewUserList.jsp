<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.User"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Users</title>
    </head>
    <body>
        <center>
            <a href="new">Add New User</a>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <a href="list">View Users</a>
        </center>
        <br/>
        <center>
            <h1>List of Users</h1>
            <table cellpadding="5" border="1">
                <thead>
                    <th>id</th>
                    <th>First Name</th>
                      <th>Last Name</th>
                        <th>Phone No</th>
                         <th>Email</th>
                         <th>action</th>
                </thead>
                <tbody>
               
                
                <c:forEach var="user" items="${userList}">
                    <tr>
                        <td><c:out value="${user.userId}"/></td>
                        <td><c:out value="${user.firstName}"/></td>
                        <td><c:out value="${user.lastName}"/></td>
                        <td><c:out value="${user.phoneNo}"/></td>
                        <td><c:out value="${user.email}"/></td>
                       
                        <td><a href="edit?id=<c:out value='${user.userId}'/>">
                                Edit
                            </a>
                                &nbsp;&nbsp;&nbsp;
                            <a href="delete?id=<c:out value='${user.userId}'/>">
                                Delete
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </center>
    </body>
</html>
