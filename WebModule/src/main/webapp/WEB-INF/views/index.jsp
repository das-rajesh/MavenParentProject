<%-- 
    Document   : index
    Created on : Jun 5, 2018, 9:25:39 AM
    Author     : Dell
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Skills </h1>
        <ul>
            <c:forEach var="skill" items="${skills}">
                <li>${skill.name}</li>
            </c:forEach>
        </ul>
    </body>
</html>
