<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<jsp:include page="../includes/header.jsp" />

<main>
<div class="row">
	<div class="col-md-8 column ui-sortable">
		<form:form action="saveEjemplar" commandName="ejemplar" method="post">
			<c:if test="${ejemplar.codigo > 0}">
				<form:label path="codigo">
					<spring:message text="ejemplar.codigo" />
				</form:label>
				<form:input path="codigo" readonly="true" size="10" disabled="true" />
				<form:hidden path="codigo" />
			</c:if>
			<div>
				<div class="form-group col-md-8 column ui-sortable">
					<form:label path="editorial">
						<spring:message text="Editorial: " />
					</form:label>
					<form:input path="editorial" cssErrorClass="" cssClass="" />
					<form:errors cssClass="" path="editorial" />
				</div>
				<div class="form-group col-md-8 column ui-sortable">
					<form:label path="numPaginas">
						<spring:message text="Número de Páginas: " />
					</form:label>
					<form:input path="numPaginas" cssClass="" cssErrorClass="" />
					<form:errors cssClass="" path="numPaginas" />
				</div>
								
				<div class="form-group col-md-8 column ui-sortable">
					<c:if test="${ejemplar.codigo != 0}">
						<input class="btn btn-outline-info" type="submit"
							value="<spring:message text="Editar Ejemplar"/>" />
					</c:if>
					<c:if test="${ejemplar.codigo == 0}">
						<input class="btn btn-outline-info" type="submit"
							value="<spring:message text="Crear Ejemplar"/>" />
					</c:if>
				</div>
		</form:form>
	</div>
	<div class="button-group col-md-8 column ui-sortable">
		<a class="btn btn-outline-success" href='<c:url value="/ejemplares"/>'>Listado
			Ejemplares<a /> <a class="btn btn-outline-success" href="../"
			type="submit">Inicio<a />
	</div>
	<div class="col-md-4 column ui-sortable"></div>
</div>

</main>

</body>
</html>