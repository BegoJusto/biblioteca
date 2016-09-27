<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page import="com.ipartek.formacion.dao.persistencia.Usuario"%>
<%@page import="java.util.List"%>

<jsp:include page="../includes/header.jsp" />

<main>
<div class="row">
	<div class="col-md-8 column ui-sortable">
		<form:form action="savePrestamo" commandName="prestamo" method="post">
			<c:if test="${prestamo.codigo > 0}">
				<form:label path="codigo">
					<spring:message text="prestamo.codigo" />
				</form:label>
				<form:input path="codigo" readonly="true" size="10" disabled="true" />
				<form:hidden path="codigo" />
			</c:if>
			<div>
				<div class="form-group col-md-8 column ui-sortable">
				<% List<Usuario> usuarios = (List<Usuario>) request.getAttribute("listado-prestamos-usuarios");%>
					<form:label path="usuario">
						<spring:message text="Usuario: " />
					</form:label>
					<form:select path="" cssErrorClass="" cssClass="">
						<form:option value="NONE">Seleccione un valor</form:option>
						<form:options items="${usuarios}"></form:options>
					</form:select>
					<form:errors cssClass="" path="" />
				</div>
				<div class="form-group col-md-8 column ui-sortable">
					<form:label path="">
						<spring:message text="Título: " />
					</form:label>
					<form:select path="" cssClass="" cssErrorClass="" />
					<form:errors cssClass="" path="" />
				</div>
				<div class="form-group col-md-8 column ui-sortable">
					<form:label path="" cssClass="" cssErrorClass="invalid">
						<spring:message text="Fecha de Recogida:" />
					</form:label>
					<form:input path="" type="text" />
					<form:errors cssClass="" path="" />
				</div>
				<div class="form-group col-md-8 column ui-sortable">
					<form:label path="" cssClass="" cssErrorClass="">
						<spring:message text="Fecha Devolución Prevista: " />
					</form:label>
					<form:input path="" type="text" />
					<form:errors cssClass="" path="" />
				</div>
				<div class="form-group col-md-8 column ui-sortable">
					<form:label path="" cssClass="" cssErrorClass="">
						<spring:message text="Fecha Devolución Real: " />
					</form:label>
					<form:input path="" type="text" />
					<form:errors cssClass="" path="" />
				</div>

				<div class="form-group col-md-8 column ui-sortable">
					<c:if test="${prestamo.codigo != 0}">
						<input class="btn btn-outline-info" type="submit"
							value="<spring:message text="Editar Prestamo"/>" />
					</c:if>
					<c:if test="${prestamo.codigo == 0}">
						<input class="btn btn-outline-info" type="submit"
							value="<spring:message text="Reservar"/>" />
					</c:if>
				</div>
		</form:form>
	</div>
	<div class="button-group col-md-8 column ui-sortable">
		<a class="btn btn-outline-success" href='<c:url value="/prestamos"/>'>Listado
			Prestamos<a /> <a class="btn btn-outline-success" href="../"
			type="submit">Inicio<a />
	</div>
	<div class="col-md-4 column ui-sortable"></div>
</div>

</main>

</body>
</html>