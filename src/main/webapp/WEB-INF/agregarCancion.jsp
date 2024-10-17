<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title> Formulario Canciones </title>
	</head>
	<body>
				<h1> Agregar cancion </h1>
			<div>
				<form:form action="/canciones/procesa/agregar" method="POST" modelAttribute="cancion">
					<div>
						<form:label path="titulo"> Título: </form:label>
						<form:input path="titulo" />
						<form:errors path="titulo" /> 
					</div>
					<div>
						<form:label path="artista"> Artista: </form:label>
						<form:input path="artista" />	
						<form:errors path="artista" /> 
					</div>
					<div>
						<form:label path="album"> Álbum: </form:label>
						<form:input path="album" />
						<form:errors path="album" /> 
					</div>
					<div>
						<form:label path="genero"> Género: </form:label>
						<form:input path="genero" />
						<form:errors path="genero" /> 
					</div>
					<div>
						<form:label path="idioma"> Idioma: </form:label>
						<form:input path="idioma" />
						<form:errors path="idioma" /> 
					</div>
					<button>Agregar Canción</button>
				</form:form>
			</div>
			<div>
				<a href="/canciones">Volver a lista de canciones</a>
			</div>
	</body>
</html>