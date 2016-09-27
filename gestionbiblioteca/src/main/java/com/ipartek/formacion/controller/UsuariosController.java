package com.ipartek.formacion.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.ipartek.formacion.dao.persistencia.Usuario;
import com.ipartek.formacion.services.UsuarioServiceImp;

@Controller
@RequestMapping(value = "/usuarios")
public class UsuariosController extends MultiActionController{
	private static final Logger logger = LoggerFactory.getLogger(UsuariosController.class);

	@Autowired
	private UsuarioServiceImp us= null;
	private ModelAndView mav = null;
	
	 @Autowired
	 @Qualifier("usuarioValidator")
	 private Validator validator;
	 
	 @InitBinder
		private void initBinder(WebDataBinder binder) {
			binder.setValidator(validator);
			
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));

		}
	

	  @RequestMapping(method = RequestMethod.GET)
	  public ModelAndView getAll() {

	    mav = new ModelAndView("/usuarios/listado");
	    List<Usuario> usuarios = us.getAll();
	    mav.addObject("listado-usuarios", usuarios);
	    return mav;

	  }

	  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	  public ModelAndView getById(@PathVariable("id") int id) {
		
	    mav = new ModelAndView("/usuarios/usuario");
	    Usuario usuario = us.getById(id);
	    mav.addObject("usuario", usuario);
	    return mav;

	  }

	  @RequestMapping(method = {RequestMethod.POST, RequestMethod.DELETE}, value = "delete/{id}")
		public String delete(@PathVariable("id") int id) {
			us.delete(id);
			return "redirect:/usuarios";
		}

	 
	  @RequestMapping(value ="/addUsuario", method = RequestMethod.GET)
	  public String addUsuario(Model model){
		  model.addAttribute("usuario", new Usuario());
		  return "/usuarios/usuario"; 
	  }
	  
	  @RequestMapping(value = "/saveUsuario", method = RequestMethod.POST)
	  public String saveUsuario(@ModelAttribute("usuario") @Validated Usuario usuario,
			  BindingResult bindingResult, Model model){
		 
		  String destino ="";
			
			if(bindingResult.hasErrors()){
				System.out.println(bindingResult.getFieldError());
								
				destino = "/usuarios/usuario"; 
				//como tiene errores, lo manda otra vez a la pagina de usuario nuevo.
			}else{
				logger.info("usuario correcto");
				System.out.println("ERRORES: " + bindingResult.getFieldError());
				logger.info("codigo= ",usuario.getCodigo());
				destino = "redirect:/usuarios";
				if(usuario.getCodigo() > 0){				
					us.update(usuario);				
				}else{
					us.create(usuario);				
				}
			}
			
			return destino; // ofuscacion de URL
	  }

	  
	  @RequestMapping(value = "/restclients",  method = RequestMethod.GET)
	  public String restRedirect(Model model) {
		  return "usuarios/listadoRest";
	  }

}
