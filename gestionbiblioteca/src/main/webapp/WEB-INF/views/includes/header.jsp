<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@page import="com.ipartek.formacion.dao.persistencia.Usuario"%>
<%@page import="com.ipartek.formacion.dao.persistencia.Libro"%>
<%@page import="com.ipartek.formacion.dao.persistencia.Ejemplar"%>
<%@page import="java.util.List"%>
<spring:url value="/resources/css/bootstrap.min.css" var="cssBootstrap" />
<spring:url value="/resources/css/font-awesome.min.css" var="cssFont" />
<spring:url value="/resources/css/styles.css" var="cssStyle" />
<spring:url value="/resources/js/bootstrap.min.js" var="jsBootstrap" />
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- CARGAMOS LOS BASICOS DE BOOTSTRAP -->
<link rel="stylesheet" href="${cssBootstrap}" />
<!-- CARGAMOS LAS FUENTES -->
<link rel="stylesheet" href="${cssFont}">
	<!-- CARGAMOS NUESTROS ESTILOS -->
<link rel="stylesheet" href="${cssStyle}">
	<!-- CARGAMOS JQUERY -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- CARGAMOS LAS LIBRERIAS JS DE BOOTSTRAP -->
<script src="${jsBootstrap}"></script>
<title>Biblioteca</title>
</head>

<body class="container-fluid">
	<header class="row">
		<h1>Lista de Usuarios</h1>
	</header>
	<nav class="navbar" role="navigation">
		<!-- 		<div class="navbar-header"> -->
		<%-- 			<a class="nav navbar-brand" href='<c:url value="/usuarios"/>'>Inicio</a> --%>
		<!-- 			<button type="button" class="navbar-toggle" data-toggle="collapse" -->
		<!-- 				data-target=".navbar-ex1-collapse"> -->
		<!-- 				<span class="sr-only">Desplegar navegación</span> <span -->
		<!-- 					class="icon-bar"></span> <span class="icon-bar"></span> <span -->
		<!-- 					class="icon-bar"></span> -->
		<!-- 			</button> -->
		<!-- 		</div> -->
		<div class="navbar navbar-collapse navbar-ex1-collapse">
			<ul class="nav navbar-nav">
				<li class="dropdown"><a class="dropdrown-toggle"
					data-toggle="dropdown" href='<c:url value="/usuarios/"/>'>Usuarios</a>
					<ul class="dropdown-menu">
						<li><a href='<c:url value="/usuarios"/>'>Usuarios</a></li>
						<li><a href='<c:url value="/usuarios/addUsuario"/>'>Crear
								Usuario</a></li>
						<li><a href='<c:url value="/usuarios/restclients"/>'>
								RestClient</a></li>
					</ul></li>
			</ul>
<!-- 			<ul class="nav navbar-nav"> -->
<!-- 				<li class="dropdown"><a class="dropdrown-toggle" -->
<%-- 					data-toggle="dropdown" href='<c:url value = "/libros/"/>'>Libros</a> --%>
<!-- 					<ul class="dropdown-menu"> -->
<%-- 						<li><a href='<c:url value = "/libros"/>'>Libros</a></li> --%>
<%-- 						<li><a href='<c:url value="/libros/addLibro"/>'>Crear --%>
<!-- 								Libro</a></li> -->
<%-- 						<li><a href='<c:url value="/libros/restclients"/>'> --%>
<!-- 								RestClient</a></li> -->
<!-- 					</ul></li> -->
<!-- 			</ul> -->
			<ul class="nav navbar-nav">
				<li class="dropdown"><a class="dropdrown-toggle"
					data-toggle="dropdown" href='<c:url value = "/ejemplares/"/>'>Ejemplares</a>
					<ul class="dropdown-menu">
						<li><a href='<c:url value="/ejemplares" />'>Ejemplares</a></li>
						<li><a href='<c:url value="/ejemplares/addEjemplar"/>'>Crear
								Ejemplar</a></li>
						<li><a href='<c:url value="/ejemplares/restclients"/>'>
								RestClient</a></li>
					</ul></li>
			</ul>
		
		</div>
	</nav>
	<!-- Hasta aquí todo el encabezado -->
	<!-- ********************************************************************** -->


