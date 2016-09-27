<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page import="com.ipartek.formacion.dao.persistencia.Usuario"%>
<%@page import="java.util.List"%>
<jsp:include page="../includes/header.jsp" />
<div class="container-fluid">
	<div class="row">
		<div class="col-xs-10 col-md-10 column ui-sortable">
			<H3>USUARIOS</H3>
			<%
					List<Usuario> usuarios = (List<Usuario>) request.getAttribute("listado-usuarios");
						
			if (!usuarios.isEmpty()) {
				%>
			<div class="table-responsive">
				<table class="table">
					<thead>
						<tr>
							<th>Nombre</th>
							<th>Apellidos</th>
							<th>Fecha de Nacimiento</th>
							<th>E-mail</th>
						</tr>
					</thead>
					<tbody>
						<%
								for (Usuario u : usuarios) {
							%>
						<tr>
							<td><%=u.getNombre()%></td>
							<td><%=u.getApellidos()%></td>
							<td><%=u.getfNacimiento()%></td>
							<td><%=u.getMail()%></td>
							<td></td>
							<td><a href="usuarios/<%=u.getCodigo()%>"
								class="btn btn-outline-danger" role="button">Modificar
									Usuario</a></td>
							<td><form action="usuarios/delete/<%=u.getCodigo()%>"
									method="post">
									<button class="btn btn-outline-danger">Borrar Usuario</button>
								</form></td>
							<td><form action="prestamos/usuario/<%=u.getCodigo()%>"
									method="post">
									<button class="btn btn-outline-danger">Ver Préstamos</button>
								</form></td>

						</tr>
						<%}%>
					</tbody>
				</table>
			</div>
			<%
								} else {%>
			No se han encontrado usuarios en la BB.DD.
			<%}	%>


		</div>

	</div>
	<div class="button-group col-md-8 column ui-sortable">
		<a class="btn btn-outline-success"
			href='<c:url value="/usuarios/addUsuario"/>'>Crear Usuario<a />
					<a class="btn btn-outline-success"
			href='<c:url value="/prestamos/reservarPrestamo"/>'>Reservar<a />
			<a class="btn btn-outline-success" href="./" type="submit">Inicio<a />
	</div>
	<div class="col-md-4 column ui-sortable"></div>
</div>
</body>
</html>


