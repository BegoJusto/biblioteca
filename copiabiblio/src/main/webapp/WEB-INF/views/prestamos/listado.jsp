<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page import="com.ipartek.formacion.dao.persistencia.Prestamo"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<jsp:include page="../includes/header.jsp" />
<div class="container-fluid">
	<div class="row">
		<div class="col-xs-8 col-md-8 column ui-sortable">
			<H3>PRÉSTAMOS</H3>
			<%
					List<Prestamo> prestamos = (List<Prestamo>) request.getAttribute("listado-prestamos");
					if (!prestamos.isEmpty()) {
				%>
			<div class="table-responsive">
				<table class="table">
					<thead>
						<tr>
							<th>Usuario</th>
							<th>Título</th>
							<th>Editorial</th>
							<th>NºPáginas</th>
							<th>Fecha Recogida</th>
							<th>Fecha Devolución</th>
							<th>Devuelto</th>
						</tr>
					</thead>
					<tbody>
						<%
								for (Prestamo p : prestamos) {
							%>
						<tr>
							<td><%=p.getUsuario().getNombre()%>, <%=p.getUsuario().getApellidos()%></td>
							<td><%=p.getEjemplar().getLibro().getTitulo()%></td>
							<td><%=p.getEjemplar().getEditorial()%></td>
							<td><%=p.getEjemplar().getNumPaginas()%></td>
							<td><%=p.getfRecogida()%></td>
							<td><%=p.getfDevolucionPrevista()%></td>
							<%if(p.getfDevolucionReal() != null){%>
							<td>Devuelto</td>
							<%}Date hoy = new Date();
							if(p.getfDevolucionPrevista().before(hoy)){%>
							<td>FALTA DEVOLVER ESTE LIBRO!!!!!!!!</td>
							<%}else{%>
							<td></td>
							<%}%>
							<td></td>
							<td><a href="prestamos/<%=p.getCodigo()%>"
								class="btn btn-outline-danger" role="button">Modificar Prestamo</a></td>
							<td><form action="prestamos/delete/<%=p.getCodigo()%>"
									method="post">
									<button class="btn btn-outline-danger">Devolver</button>
								</form></td>

						</tr>
						<%}%>
					</tbody>
				</table>
			</div>
			<%
								} else {%>
			No se han encontrado prestamos en la BB.DD.
			<%}	%>


		</div>

	</div>
	<div class="button-group col-md-8 column ui-sortable">
		<a class="btn btn-outline-success"
			href='<c:url value="/prestamos/reservarPrestamo"/>'>Reservar<a />
			<a class="btn btn-outline-success" href="./" type="submit">Inicio<a />
	</div>
	<div class="col-md-4 column ui-sortable"></div>
</div>
</body>
</html>


