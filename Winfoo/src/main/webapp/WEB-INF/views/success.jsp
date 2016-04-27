<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Upload OK</title>
    </head>
    <body>
        Fichier  <strong>${fileName}</strong> chargé avec succés.
        <br/><br/>
        Liste des erreurs:<br/><br/>
        ${errors}
        <a href="<c:url value='/upload' />">Retour</a> 
    </body>
</html>