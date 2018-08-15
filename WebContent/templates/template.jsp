<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<!-- Scriptlet - permite acesso a linguagem Java -->
<%
	/* Setando na Sessao o Caminho do WebContent */
	request.getSession().setAttribute( "rootWeb", request.getContextPath() );
%>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Sistema para Controle de Estoque">
	<meta name="author" content="Thiago Belini">
	<title>Control Stock Solution</title>
	<jsp:include page="imports/imports-css.jsp" />
</head>

<body>
	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
		
			<!--sp:include page="cabecalho.jsp" /-->
			<tiles:insert name="header"/>

			<!--jsp:include page="menu.jsp" /-->
			<tiles:insert name="menu"/>
		</nav>

		<div id="page-wrapper">
		
			<!-- jsp:include page="../paginas/categoria/categoria-formulario.jsp"/-->
			<tiles:insert name="body"/>
		
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->


</body>
</html>