package com.ipartek.formacion.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ipartek.formacion.dao.persistencia.Ejemplar;
public class EjemplarValidator implements Validator{

	public EjemplarValidator() {
		
	}

	@Override
	public boolean supports(Class<?>arg0) {
		
		return Ejemplar.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {		
		Ejemplar eje = (Ejemplar) obj;
		
		if (eje.getCodigo() < 0) {errors.rejectValue("codigo", "valorNegativo",
				new Object[] { "'codigo'" }, "no puede ser ese valor");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "editorial",
				"El campo Editorial no puede estar en blanco");
		
		if(eje.getNumPaginas() < 5){errors.rejectValue("numPaginas", "valorNegativo",
				new Object[] { "'numPaginas'" }, "El número de páginas debe ser mayor de 5");
			
		}

		
	}

}
