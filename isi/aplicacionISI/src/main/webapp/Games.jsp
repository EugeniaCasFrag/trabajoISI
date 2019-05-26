<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Esto es lo que has buscado:</title>
</head>
<body>
<h1>Esto es lo que has buscado majet@:</h1>
<h3>Nombre del juego que quieres: ${yourGame.nombre}</h3>
<h3>La plataforma en la que quieres jugar: ${yourGame.plataforma}</h3>
<h3>La edicion que quieres: ${yourGame.edicion}</h3>

<h1>Y esto es lo que hemos encontrado:  </h1>
<h3>Size: ${yourGame.money.size()}</h3>
<h3>Haz puto algo: ${yourGame.money.get(i).getNombre()}</h3>
<c:forEach var="pos" items="${yourGame.money}">
	<c:out value="${pos.nombre}"/>
<br/>
</c:forEach>  


</body>
</html>