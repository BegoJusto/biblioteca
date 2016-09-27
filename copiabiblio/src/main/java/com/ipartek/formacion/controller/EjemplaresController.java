package com.ipartek.formacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.ipartek.formacion.dao.persistencia.Ejemplar;
import com.ipartek.formacion.services.EjemplarServiceImp;

@Controller
@RequestMapping(value="/ejemplares")
public class EjemplaresController extends MultiActionController {
	private static final Logger logger = LoggerFactory.getLogger(EjemplaresController.class);

	@Autowired
	private EjemplarServiceImp es = null;
	private ModelAndView mav = null;
	
	@Autowired
	@Qualifier("ejemplarValidator")
	private Validator validator;
	
	 @InitBinder
	  private void initBinder(WebDataBinder binder) {
			binder.setValidator(validator);		
	  }
	
	 @RequestMapping(value = "/addEjemplar", method = RequestMethod.GET)
	 public String addEjemplar(Model model){
		 
		 model.addAttribute("ejemplar", new Ejemplar());
		 
		 return "/ejemplares/ejemplar";
	 }
	 
	 @RequestMapping(value = "/saveEjemplar", method = RequestMethod.POST)
	 public String saveEjemplar(@ModelAttribute("ejemplar") @Validated Ejemplar ejemplar, BindingResult bindingResult, Model model){
		 
		 String destino ="";
		 
		 if(bindingResult.hasErrors()){
			 System.out.println(bindingResult.getFieldError());
			 
			 logger.info("El ejemplar tiene errores");
			 logger.info("Editorial", ejemplar.getEditorial());
			 logger.info("Código", ejemplar.getCodigo());
			 
			 destino = "/ejemplares/ejemplar";
		 }else{
			 logger.info("ejemplar correcto");
			 
			 destino = "redirect:/ejemplares";
			 
			 if(ejemplar.getCodigo() > 0){
				 es.update(ejemplar);
			 }else{
				 es.create(ejemplar);
			 }
		 }
		 
		return destino;
		 
	 }
	 
	 @RequestMapping(value= "/{id}", method = RequestMethod.GET)
	 public ModelAndView getById(@PathVariable("id") int id){
		 
		 mav = new ModelAndView("/ejemplares/ejemplar");
		 Ejemplar ejemplar = es.getById(id);
		 mav.addObject("ejemplar",ejemplar);
		
		 return mav;	 
		 
	 }
	 
	 @RequestMapping(method = RequestMethod.GET)
	 public ModelAndView getAll(){
		 
		 mav = new ModelAndView("/ejemplares/listado");
		 List<Ejemplar> ejemplares = es.getAll();
		 mav.addObject("listado-ejemplares", ejemplares);
		 
		 return mav;
	 }
	 
	 @RequestMapping(value = "delete/{id}", method = {RequestMethod.POST, RequestMethod.DELETE})
	 public String delete(@PathVariable("id") int id){
		 
		 es.delete(id);
		 return "redirect:/ejemplares";
	 }
	
	@RequestMapping(value = "/restclients", method = RequestMethod.GET)
	public String restRedirect(Model model){
		return "ejemplares/listadoRest";
	}
	

}
