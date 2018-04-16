<%-- 
    Document   : ClientList
    Created on : 15-Apr-2018, 4:04:32 AM
    Author     : parminder singh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Marketing Agent</title>
        <base href="/MarketingAgent/"/>
      
    </head>
    <body>
        <center>
        <h1>Marketing Agent</h1>
        <h2>
            <a href="new">Add New Client</a>
            &nbsp;&nbsp;&nbsp;
            <a href="list">List All Clients</a>
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Clients</h2></caption>
            <tr>
                <th>ID</th>
                <th>Agent ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Street Number</th>
                <th>Street Name</th>
                <th>City</th>
                <th>Province</th>
                <th>Postal Code</th>
                <th>Tel Office</th>
                <th>Tel Cell</th>
                <th>Email</th>
                <th>Company</th>
                <th>Company Type</th>
                
               
            </tr>
            <c:forEach var="client" items="${listClient}">
                <tr>
                    <td><c:out value="${client.id}" /></td>
                    <td><c:out value="${client.agentId}" /></td>
                    <td><c:out value="${client.firstName}" /></td>
                    <td><c:out value="${client.lastName}" /></td>
                    <td><c:out value="${client.streetNumber}" /></td>
                    <td><c:out value="${client.streetName}" /></td>
                    <td><c:out value="${client.city}" /></td>
                    <td><c:out value="${client.province}" /></td>
                    <td><c:out value="${client.postalCode}" /></td>
                    <td><c:out value="${client.telOffice}" /></td>
                    <td><c:out value="${client.telCell}" /></td>
                    <td><c:out value="${client.email}" /></td>
                    <td><c:out value="${client.company}" /></td>
                    <td><c:out value="${client.companyType}" /></td>
                    <td>
                        <a href="edit?id=<c:out value='${client.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="delete?id=<c:out value='${client.id}' />">Delete</a>                     
                    </td>
                  
                   
                </tr>
            </c:forEach>
        </table>
    </div>   
    </body>
</html>
