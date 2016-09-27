package com.ipartek.formacion.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ipartek.formacion.dao.persistencia.Libro;

public class LibroValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		
		return Libro.class.equals(arg0);
	}
	@Override
	public void validate(Object obj, Errors errors) {		
		Libro lib = (Libro) obj;
		
		if (lib.getCodigo() < 0) {errors.rejectValue("codigo", "valorNegativo",
				new Object[] { "'codigo'" }, "no puede ser ese valor");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "titulo","Título incorrecto",
				"El Título no puede estar en blanco");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "autor","Autor Incorrecto",
				"El Autor no puede estar en blanco");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "isbn",
				"El ISBN no puede estar en blanco");
		
		if (lib.getEjemplares().isEmpty() ) {errors.rejectValue("numEjemplares", "valorNegativo",
				new Object[] { "'numEjemplares'" }, "Tiene que dar de alta por lo menos un ejemplar");
		}

		
	}

}
