<%-- 
    Document   : ClientForm
    Created on : 15-Apr-2018, 4:03:39 AM
    Author     : parminder singh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Marketing Agent</title>
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
          <c:if test="${client != null}">
            <form action="update" method="post">
        </c:if>
       
        <c:if test="${client == null}">
            
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${client != null}">
                        Edit Client
                    </c:if>
                    <c:if test="${client == null}">
                        Add New Client
                        
                    </c:if>
                </h2>
            </caption>
                <c:if test="${client != null}">
                    <input type="hidden" name="id" value="<c:out value='${client.id}' />" />
                </c:if>           
            <tr>
                <th>Agent Id: </th>
                <td>
                    <input type="text" name="title" size="45"
                            value="<c:out value='${client.agentId}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>First Name: </th>
                <td>
                    <input type="text" name="author" size="45"
                            value="<c:out value='${client.firstName}' />"
                    />
                </td>
            </tr>
             <tr>
                <th>Last Name: </th>
                <td>
                    <input type="text" name="author" size="45"
                            value="<c:out value='${client.lastName}' />"
                    />
                </td>
            </tr>
             <tr>
                <th>Street Number: </th>
                <td>
                    <input type="text" name="author" size="45"
                            value="<c:out value='${client.streetNumber}' />"
                    />
                </td>
            </tr>
             <tr>
                <th>Street Name: </th>
                <td>
                    <input type="text" name="author" size="45"
                            value="<c:out value='${client.streetName}' />"
                    />
                </td>
            </tr>
             <tr>
                <th>City: </th>
                <td>
                    <input type="text" name="author" size="45"
                            value="<c:out value='${client.city}' />"
                    />
                </td>
            </tr>
             <tr>
                <th>Province: </th>
                <td>
                    <input type="text" name="author" size="45"
                            value="<c:out value='${client.province}' />"
                    />
                </td>
            </tr>
             <tr>
                <th>Postal Code: </th>
                <td>
                    <input type="text" name="author" size="45"
                            value="<c:out value='${client.postalCode}' />"
                    />
                </td>
            </tr>
             <tr>
                <th>Tel Office: </th>
                <td>
                    <input type="text" name="author" size="45"
                            value="<c:out value='${client.telOffice}' />"
                    />
                </td>
            </tr>
             <tr>
                <th>Tel Cell: </th>
                <td>
                    <input type="text" name="author" size="45"
                            value="<c:out value='${client.telCell}' />"
                    />
                </td>
            </tr>
             <tr>
                <th>Email: </th>
                <td>
                    <input type="text" name="author" size="45"
                            value="<c:out value='${client.email}' />"
                    />
                </td>
            </tr>
             <tr>
                <th>Company: </th>
                <td>
                    <input type="text" name="author" size="45"
                            value="<c:out value='${client.company}' />"
                    />
                </td>
            </tr>
             <tr>
                <th>Company Type: </th>
                <td>
                    <input type="text" name="author" size="45"
                            value="<c:out value='${client.companyType}' />"
                    />
                </td>
            </tr>
           
            
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
          
        </table>
        </form>
    </div>   
    </body>
</html>
