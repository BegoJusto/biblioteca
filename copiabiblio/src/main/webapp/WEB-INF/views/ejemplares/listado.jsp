<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page import="com.ipartek.formacion.dao.persistencia.Ejemplar"%>
<%@page import="java.util.List"%>
<jsp:include page="../includes/header.jsp" />
<div class="container-fluid">
	<div class="row">
		<div class="col-xs-8 col-md-8 column ui-sortable">
			<H3>EJEMPLARES</H3>
			<%
					List<Ejemplar> ejemplares = (List<Ejemplar>) request.getAttribute("listado-ejemplares");
					if (!ejemplares.isEmpty()) {
				%>
			<div class="table-responsive">
				<table class="table">
					<thead>
						<tr>
							<th>Editorial</th>
							<th>N�mero de P�ginas</th>
						</tr>
					</thead>
					<tbody>
						<%
								for (Ejemplar e : ejemplares) {
							%>
						<tr>
							<td><%=e.getEditorial()%></td>
							<td><%=e.getNumPaginas()%></td>	
							<td></td>
							<td><a href="ejemplares/<%=e.getCodigo()%>"
								class="btn btn-outline-danger" role="button">Modificar
									Ejemplar</a></td>
							<td><form action="ejemplares/delete/<%=e.getCodigo()%>"
									method="post">
									<button class="btn btn-outline-danger">Borrar Ejemplar</button>
								</form></td>
											
						</tr>
						<%}%>
					</tbody>
				</table>
			</div>
			<%
								} else {%>
			No se han encontrado ejemplares en la BB.DD.
			<%}	%>


		</div>

	</div>
	<div class="button-group col-md-8 column ui-sortable">
		<a class="btn btn-outline-success"
			href='<c:url value="/ejemplares/addEjemplar"/>'>Crear Ejemplar<a />
			<a class="btn btn-outline-success" href="./" type="submit">Inicio<a />
	</div>
	<div class="col-md-4 column ui-sortable"></div>
</div>
</body>
</html>


