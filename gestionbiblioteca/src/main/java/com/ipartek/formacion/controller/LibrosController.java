package com.ipartek.formacion.controller;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

import com.ipartek.formacion.dao.persistencia.Libro;
import com.ipartek.formacion.services.LibroServiceImp;

@Controller
@RequestMapping(value = "/libros")
public class LibrosController extends MultiActionController {
	private static final Logger logger = LoggerFactory.getLogger(LibrosController.class);
	
	@Autowired
	private LibroServiceImp ls = null;
	private ModelAndView mav = null;
	
	@Autowired
	@Qualifier("libroValidator")
	private Validator validator;

	 @InitBinder
	  private void initBinder(WebDataBinder binder) {
			binder.setValidator(validator);		
	  }
	 
	 @RequestMapping(value = "/addLibro", method = RequestMethod.GET)
	 public String addLibro(Model model){
		 
		 model.addAttribute("libro", new Libro());
		 
		 return "/libros/libro";
	 }
	 
	 @RequestMapping(value = "/saveLibro", method = RequestMethod.POST)
	 public String saveLibro(@ModelAttribute("libro") @Validated Libro libro, BindingResult bindingResult, Model model){
		 
		 String destino ="";
		 
		 if(bindingResult.hasErrors()){
			 System.out.println(bindingResult.getFieldError());
						 
			 destino = "/libros/libro";
		 }else{
			 logger.info("libro correcto");
			 
			 destino = "redirect:/libros";
			 
			 if(libro.getCodigo() > 0){
				 ls.update(libro);
			 }else{
				 ls.create(libro);
			 }
		 }
		 
		return destino;
		 
	 }
	 
	 @RequestMapping(value= "/{id}", method = RequestMethod.GET)
	 public ModelAndView getById(@PathVariable("id") int id){
		 
		 mav = new ModelAndView("/libros/libro");
		 Libro libro = ls.getById(id);
		 mav.addObject("libro",libro);
		
		 return mav;	 
		 
	 }
	 
	 @RequestMapping(method = RequestMethod.GET)
	 public ModelAndView getAll(){
		 
		 mav = new ModelAndView("/libros/listado");
		 List<Libro> libros = ls.getAll();
		 mav.addObject("listado-libros", libros);
		 
		 return mav;
	 }
	 
	 @RequestMapping(value = "delete/{id}", method = {RequestMethod.POST, RequestMethod.DELETE})
	 public String delete(@PathVariable("id") int id){
		 
		 ls.delete(id);
		 return "redirect:/libros";
	 }
	
	@RequestMapping(value = "/restclients", method = RequestMethod.GET)
	public String restRedirect(Model model){
		return "libros/listadoRest";
	}


}
