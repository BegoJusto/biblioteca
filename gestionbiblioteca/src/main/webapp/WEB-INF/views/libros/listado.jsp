<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page import="com.ipartek.formacion.dao.persistencia.Libro"%>
<%@page import="java.util.List"%>
<jsp:include page="../includes/header.jsp" />
<div class="container-fluid">
	<div class="row">
		<div class="col-xs-8 col-md-8 column ui-sortable">
			<H3>LIBROS</H3>
			<%
					List<Libro> libros = (List<Libro>) request.getAttribute("listado-libros");
					if (!libros.isEmpty()) {
				%>
			<div class="table-responsive">
				<table class="table">
					<thead>
						<tr>
							<th>TÃ­tulo</th>
							<th>Autor</th>
							<th>ISBN</th>
							<th>Nº de Ejemplares</th>
							
						</tr>
					</thead>
					<tbody>
						<%
								for (Libro l : libros) {
							%>
						<tr>
							<td><%=l.getTitulo()%></td>
							<td><%=l.getAutor()%></td>
							<td><%=l.getIsbn()%></td>
							<td><%=l.getNumEjemplares()%></td>
							<td></td>
							<td><a href="libros/<%=l.getCodigo()%>"
								class="btn btn-outline-danger" role="button">Modificar Libro</a></td>
							<td><form action="libros/delete/<%=l.getCodigo()%>"
									method="post">
									<button class="btn btn-outline-danger">Borrar Libro</button>
								</form></td>

						</tr>
						<%}%>
					</tbody>
				</table>
			</div>
			<%
								} else {%>
			No se han encontrado libros en la BB.DD.
			<%}	%>


		</div>

	</div>
	<div class="button-group col-md-8 column ui-sortable">
		<a class="btn btn-outline-success"
			href='<c:url value="/libros/addLibro"/>'>Crear Libro<a />
			<a class="btn btn-outline-success" href="./" type="submit">Inicio<a />
	</div>
	<div class="col-md-4 column ui-sortable"></div>
</div>
</body>
</html>


