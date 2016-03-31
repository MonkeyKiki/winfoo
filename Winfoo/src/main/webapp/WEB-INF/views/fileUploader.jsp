<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Spring 4 MVC File Upload Example</title>
    </head>
    <body> 
        <form:form method="POST" modelAttribute="pgmFile" enctype="multipart/form-data">
            <label for="file">Upload a file</label>
            <form:input type="file" path="file" id="file"/>
            <form:errors path="file"/>
            <input type="submit" value="Upload">
        </form:form>
        <a href="<c:url value='/' />">Home</a>
    </body>
</html>