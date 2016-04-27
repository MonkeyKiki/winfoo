<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Upload fichier PGM</title>
    </head>
    <body> 
        <form:form method="POST" modelAttribute="pgmFileForm" enctype="multipart/form-data">
            <label for="file">Chargement d'un fichier PGM csv</label><br/>
            <form:input type="file" path="file" id="file"/><br/>
            <form:errors path="file" cssStyle="color: red;"/><br/><br/>
            <input type="submit" value="Upload"><br/><br/>
			<form:checkbox path="presenceEntetes"/>Présence d'entêtes dans le fichier ?<br/>
			<form:checkbox path="purgeData"/>Supprimer les données en base ?<br/>
        </form:form>
    </body>
</html>