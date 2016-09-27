<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<jsp:include page="../includes/header.jsp" />

<main>
<div class="row">
	<div class="col-md-8 column ui-sortable">
		<form:form action="saveLibro" commandName="libro" method="post">
			<c:if test="${libro.codigo > 0}">
				<form:label path="codigo">
					<spring:message text="libro.codigo" />
				</form:label>
				<form:input path="codigo" readonly="true" size="10" disabled="true" />
				<form:hidden path="codigo" />
			</c:if>
			<div>
				<div class="form-group col-md-8 column ui-sortable">
					<form:label path="titulo">
						<spring:message text="TÃ­tulo: " />
					</form:label>
					<form:input path="titulo" cssErrorClass="" cssClass="" />
					<form:errors cssClass="" path="titulo" />
				</div>
				<div class="form-group col-md-8 column ui-sortable">
					<form:label path="autor">
						<spring:message text="Autor: " />
					</form:label>
					<form:input path="autor" cssClass="" cssErrorClass="" />
					<form:errors cssClass="" path="autor" />
				</div>
				<div class="form-group col-md-8 column ui-sortable">
					<form:label path="isbn" cssClass="" cssErrorClass="invalid">
						<spring:message text="ISBN:" />
					</form:label>
					<form:input path="isbn" type="text" />
					<form:errors cssClass="" path="isbn" />
				</div>
				<div class="form-group col-md-8 column ui-sortable">
					<form:label path="numEjemplares" cssClass="" cssErrorClass="">
						<spring:message text="Nº Ejemplares: " />
					</form:label>
					<form:input path="numEjemplares" type="text" />
					<form:errors cssClass="" path="numEjemplares" />
				</div>
				
				<div class="form-group col-md-8 column ui-sortable">
					<c:if test="${libro.codigo != 0}">
						<input class="btn btn-outline-info" type="submit"
							value="<spring:message text="Editar Libro"/>" />
					</c:if>
					<c:if test="${libro.codigo == 0}">
						<input class="btn btn-outline-info" type="submit"
							value="<spring:message text="Crear Libro"/>" />
					</c:if>
				</div>
		</form:form>
	</div>
	<div class="button-group col-md-8 column ui-sortable">
		<a class="btn btn-outline-success" href='<c:url value="/libros"/>'>Listado
			Libros<a /> <a class="btn btn-outline-success" href="../"
			type="submit">Inicio<a />
	</div>
	<div class="col-md-4 column ui-sortable"></div>
</div>

</main>

</body>
</html>