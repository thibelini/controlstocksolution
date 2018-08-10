<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	</head>
	<body>
		<form action="par-ou-impar.jsp">
			<label>Nome: </label>
			<input type="text" name="nome" placeholder="Digite o Nome" maxlength="80">
			<br>
			<label>Numero: </label>
			<input type="number" name="numero" placeholder="Digite o Numero" maxlength="10" min="5" max="25">
			<br>
			<br>
			<button type="submit">Enviar Dados</button>
			<a href="hello?texto=ddddde" >Enviar via GET</a>
			
			<core:if test="${param.nome != null}">
				<%
					int numero = Integer.parseInt( request.getParameter( "numero" ) ) ;	
					if(numero %2==0){
				%>
				<h2>Numero é Par</h2>
				<%
					}else{
				%>
				<h2>Numero é Impar</h2>
				<%
					}
				%>
				
				<core:if test="${param.numero %2==0}">
				<h2>Numero é Par</h2>
				</core:if>
				<core:if test="${param.numero %2!=0}">
				<h2>Numero é Impar</h2>
				</core:if>

			</core:if>
		</form>
	</body>
</html>