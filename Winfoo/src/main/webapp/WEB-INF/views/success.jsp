<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>File Upload Success</title>
    </head>
    <body>
        File  <strong>${fileName}</strong> uploaded successfully.
        <br/><br/>
        <a href="<c:url value='/' />">Home</a> 
    </body>
</html>