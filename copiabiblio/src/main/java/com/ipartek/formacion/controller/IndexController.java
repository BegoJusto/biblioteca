package com.ipartek.formacion.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ipartek.formacion.dao.persistencia.Usuario;
import com.ipartek.formacion.services.UsuarioServiceImp;

@Controller
public class IndexController {
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private UsuarioServiceImp usuarioService;	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(){
		ModelAndView mav = new ModelAndView("index");
		
		logger.info("Carga la página con éxito");
		
		List<Usuario> usuarios = usuarioService.getAll();
		mav.addObject("listado-usuarios", usuarios);
		
		return mav;
	}
	

}
