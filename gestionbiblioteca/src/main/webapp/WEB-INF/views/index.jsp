<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page import="com.ipartek.formacion.dao.persistencia.Usuario"%>
<%@page import="java.util.List"%>
<jsp:include page="includes/header.jsp" />

<section>
	<header>
		<h2>Listado de Usuarios Conectados</h2>
	</header>
	<div>
		<%
	ServletContext context = getServletContext();
	List<Usuario> usuarios = (List<Usuario>) request.getAttribute("listado-usuarios");;
			//(List<Usuario>)context.getAttribute(Constantes.ATT_LIST_USUARIOS);
	
	if(usuarios!=null){
		%>

		<div class="row">			
			<div class="col-xs-3">Nombre</div>
			<div class="col-xs-3">Alias</div>
			<div class="col-xs-2"></div>
		</div>
		<%
		
		for(Usuario user: usuarios){
			
			%>
		<div class="row">			
			<div class="col-xs-3"><%=user.getUsername() %></div>
			<div class="col-xs-3"><%=user.getPassword() %></div>
			<div class="col-xs-2">
				<a class="btn btn-info" href="">Expulsar Usuario</a>
			</div>
		</div>
		<%
		}
	}else{
		%>
		<p>No hay usuarios conectados</p>
		<%
	}
	%>
	</div>
</section>


<section>
<div class="panel-body">
	<form class="form-horizontal" action=""
		method="post" role="form">
		<div class="input-group">
			<c:set var="userName" value="" />
			<label class="sr-only" for="">Usuario</label><span
				class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
			<input id=""
				name="" type="text"
				class="form-control" value=""
				placeholder="Introduzca su usuario">

		</div>
		<div class="input-group">
			<label class="sr-only" for="">Contrase�a:</label>
			<span class="input-group-addon"><i
				class="glyphicon glyphicon-lock"></i></span> <input
				value=""
				name=""
				id="" type="password"
				class="form-control" placeholder="Introduzca su contrase�a">
		</div>

<!-- 		<div class="input-group"> -->
<%-- 			<label class="sr-only" for="<%=Constantes.PAR_IDIOMA%>">Idioma:</label> --%>
<%-- 			<select name="<%=Constantes.PAR_IDIOMA %>" --%>
<%-- 				id="<%=Constantes.PAR_IDIOMA %>"> --%>
<%-- 				<c:forEach items="<%=Idioma.values() %>" var="idioma"> --%>
<%-- 					<option value="${idioma.codigo}">${idioma.nombre}</option> --%>
<%-- 				</c:forEach> --%>
<!-- 			</select> -->
<!-- 		</div> -->
		<div class="input-group">
			<div class="checkbox" style="padding-left: 20px;">
				<input id=""
					name="" type="checkbox" value="1"><label
					for="">Recuérdame</label>
			</div>
		</div>


		<div class="form-group">
			<div class="col-xs-12 controls">
				<button type="submit" id="btn-login" class="btn btn-success">Aceptar
				</button>

			</div>
		</div>
	</form>
</div>
<!--panel-body-->
</section>
</body>
</html>