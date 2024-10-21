<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Artistas</title>
</head>
<body>
	<h2>Lista de Artistas</h2>
    <ul>
        <c:forEach items="${Artistas}" var="artista">
            <li><a href="/artistas/detalle/${idArtista}">${artista.nombre} ${artista.apellido}</a></li>
        </c:forEach>
    </ul>
    <a href="/canciones">Ir a canciones</a>
</body>
</html>