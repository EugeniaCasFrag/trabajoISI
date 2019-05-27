<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<<<<<<< HEAD
    <head>
        <meta charset="UTF-8">
        <title>Resultados</title>
        <meta name="author" content="Jairo Luis Abril Moya y Eugenia Castillo Fragoso">
        <link rel="stylesheet" href="estilosJSP.css">
    </head>
    <body>
        <header>
            <h2>Esto es lo que has buscado:</h2>
            <h3>El juego que quieres: <b class = "letraeugenia">${yourGame.nombre}</b></h3>
			<h3>La plataforma en la que quieres jugar: <b class ="letraeugenia">${yourGame.plataforma}</b></h3>
			<h3>La edicion que buscas: <b class="letraeugenia">${yourGame.edicion} </b></h3>
        </header>
        <div class="resultados">
            <h2>Y esto es lo que te hemos encontrado: </h2>
            <ul class="lista">
                <%! int contador=0; %>
                <%! String pagina="HELLO"; %>
                <c:forEach var="pos" items="${yourGame.money}">
	                   <% if(contador==0){ 
	                       pagina="TiendaCPU.com"; 
                		 }else if (contador == 1) { 
                    		pagina="Instant-gaming.com";
                		}else {
                    		pagina="Amazon.com";
                	 } %>
	                <h3><%=pagina %></h3>
	                <li><c:out value="${pos.nombre}"/></li>
	                <li><a href="${pos.getURL()}"><c:out value="si me quieres comprar pulsame"/></a></li>
	                <li> <c:out value="${pos.getPrecio()}"/></li>
	                
                <br/>
                <% contador++; %>
                </c:forEach>
            </ul>
        </div>

    </body>
=======
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
>>>>>>> branch 'master' of https://github.com/EugeniaCasFrag/trabajoISI.git
</html>