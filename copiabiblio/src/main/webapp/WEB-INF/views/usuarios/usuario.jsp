<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="../includes/header.jsp" />

<main>
<div class="row">
	<div class="col-md-12 col-xs-12 ui-sortable">
		<form:form action="saveUsuario" commandName="usuario" method="post">
			<c:if test="${usuario.codigo > 0}">
				<form:label path="codigo">
					<spring:message text="usuario.codigo" />
				</form:label>
				<form:input path="codigo" readonly="true" size="10" disabled="true" />
				<form:hidden path="codigo" />
			</c:if>
			<div class="col-md-5 col-xs-5 ui-sortable">
				<div class="form-group col-md-8 column ui-sortable">
					<form:label path="nombre">
						<spring:message text="Nombre: " />
					</form:label>
					<form:input path="nombre" cssErrorClass="" cssClass="" />
					<form:errors cssClass="" path="nombre" />
				</div>
				<div class="form-group col-md-8 col-xs-6 ui-sortable">
					<form:label path="apellidos">
						<spring:message text="Apellidos: " />
					</form:label>
					<form:input path="apellidos" cssClass="" cssErrorClass="errors" />
					<form:errors cssClass="" path="apellidos" />
				</div>
				<div class="form-group col-md-8 col-xs-6 ui-sortable">
					<form:label path="mail" cssClass="" cssErrorClass="invalid">
						<spring:message text="e-mail:" />
					</form:label>
					<form:input path="mail" type="mail" />
					<form:errors cssClass="" path="mail" />
				</div>
			</div>

			<div class="col-md-5 col-xs-5 ui-sortable">
				<div class="form-group col-md-8 column ui-sortable">
					<form:label path="fNacimiento" cssClass="" cssErrorClass="errors">
						<spring:message text="Fecha de Nacimiento: " />
					</form:label>
					<form:input type="date" class="date" pattern='dd-MM-yyyy'
						path="fNacimiento" />
					<form:errors path="fNacimiento" cssClass="" />
				</div>

				<div class="form-group col-md-8 col-xs-6 ui-sortable">
					<form:label path="username" cssClass="" cssErrorClass="">
						<spring:message text="Username: " />
					</form:label>
					<form:input type="text" path="username" />
					<form:errors path="username" cssClass="" />
				</div>

				<div class="form-group col-md-8 column ui-sortable">
					<form:label path="password" cssClass="" cssErrorClass="">
						<spring:message text="Password: " />
					</form:label>
					<form:input type="text" path="password" />
					<form:errors cssClass="" />
				</div>
			</div>
			<div class="col-md-2 col-xs-2 ui-sortable"></div>
			<div class="col-md-8 col-xs-8 ui-sortable">
			<div class="form-group col-md-8 column ui-sortable">
				<c:if test="${usuario.codigo != 0}">
					<input class="btn btn-outline-info" type="submit"
						value="<spring:message text="Editar Usuario"/>" />
				</c:if>
				<c:if test="${usuario.codigo == 0}">
					<input class="btn btn-outline-info" type="submit"
						value="<spring:message text="Crear Usuario"/>" />
				</c:if>
			</div>
			</div>
		</form:form>
	</div>
	<div class="button-group col-md-8 column ui-sortable">
		<a class="btn btn-outline-success" href='<c:url value="/usuarios"/>'>Listado
			Usuarios<a /> <a class="btn btn-outline-success" href="../"
			type="submit">Inicio<a />
	</div>

</div>
</div>
</main>

</body>
</html>