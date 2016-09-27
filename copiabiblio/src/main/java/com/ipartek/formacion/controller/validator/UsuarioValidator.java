package com.ipartek.formacion.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ipartek.formacion.dao.persistencia.Usuario;

public class UsuarioValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		
		return Usuario.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "nombre", "nombreVacio","Nombre requerido");
		Usuario usu = (Usuario) obj;
		
		if (usu.getCodigo() < 0) {errors.rejectValue("codigo", "valorNegativo",
				new Object[] { "'codigo'" }, "no puede ser ese valor");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apellidos", "Apellidos Incorrectos",
				"Los apellidos no pueden estar en blanco");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mail", "Mail Incorrecto",
				"El mail no puede estar en blanco");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fNacimiento", "Fecha Incorrecta",
				"La fecha no puede estar en blanco");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "Username Incorrecto",
				"El Username no puede estar en blanco");

		
	}

}
