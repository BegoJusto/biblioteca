package com.ipartek.formacion.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
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
import com.ipartek.formacion.dao.persistencia.Prestamo;
import com.ipartek.formacion.dao.persistencia.Usuario;
import com.ipartek.formacion.services.EjemplarServiceImp;
import com.ipartek.formacion.services.PrestamoServiceImp;
import com.ipartek.formacion.services.UsuarioServiceImp;
import com.ipartek.formacion.services.interfaces.EjemplarService;
import com.ipartek.formacion.services.interfaces.UsuarioService;

@Controller
@RequestMapping(value="/prestamos")
public class PrestamosController extends MultiActionController {
	private static final Logger logger = LoggerFactory.getLogger(PrestamosController.class);

	@Autowired
	private PrestamoServiceImp ps = null;
	private ModelAndView mav = null;
	private UsuarioServiceImp us = null;
	private EjemplarServiceImp es = null;	
//	private List<Usuario> usuarios = new ArrayList<Usuario>();
//	private List<Ejemplar> ejemplares = new ArrayList<Ejemplar>();

//	@Autowired
//	@Qualifier("prestamoValidator")
//	private Validator validator;
	
//	 @InitBinder
//	  private void initBinder(WebDataBinder binder) {
//			binder.setValidator(validator);		
//	  }
	
	 @RequestMapping(value = "/reservarPrestamo", method = RequestMethod.GET)
	 public String reservarPrestamo(@ModelAttribute("usuarios") UsuarioServiceImp usuarios,
			 @ModelAttribute("ejemplares") EjemplarServiceImp ejemplares, Model model){	
		 mav = new ModelAndView("/prestamos/prestamo");
		 
		 usuarios = (UsuarioServiceImp) us.getAll();
		 logger.info("usuarios: ", usuarios);
		 mav.addObject("listado-prestamos-usuarios",usuarios);
		 
		 ejemplares = (EjemplarServiceImp) es.getAll();
		 mav.addObject("listado-prestamos-ejemplos",ejemplares);
		 
		 model.addAttribute("prestamo", new Prestamo());
		 
		 return "/prestamos/prestamo";
	 }
	 
	 @RequestMapping(value = "/savePrestamo", method = RequestMethod.POST)
	 public String savePrestamo(@ModelAttribute("prestamo") @Valid Prestamo prestamo, BindingResult bindingResult, Model model){
		 
		 String destino ="";
		 
		 if(bindingResult.hasErrors()){
			 System.out.println(bindingResult.getFieldError());
			 
			 destino = "/prestamos/prestamo";
		 }else{
			 logger.info("Préstamo correcto");
			 
			 destino = "redirect:/prestamos";
			 
			 if(prestamo.getCodigo() > 0){
				 ps.update(prestamo);
			 }else{
				 ps.create(prestamo);
			 }
		 }
		 
		return destino;
		 
	 }
	 
	 @RequestMapping(value="/usuario/{id}", method = RequestMethod.POST)
	 public ModelAndView getByIdUsuario(@PathVariable("id") int id){
		 
		 mav = new ModelAndView("/prestamos/listado");
		 List<Prestamo> prestamos = ps.getByIdUsuario(id);
		 mav.addObject("listado-prestamos",prestamos);
		
		 return mav;		 
	 }
	 
	 @RequestMapping(value= "/{id}", method = RequestMethod.GET)
	 public ModelAndView getById(@PathVariable("id") int id){
		 
		 mav = new ModelAndView("/prestamos/prestamo");
		 Prestamo prestamo = ps.getById(id);
		 mav.addObject("prestamo",prestamo);
		
		 return mav;	 
		 
	 }
	 
	 @RequestMapping(method = RequestMethod.GET)
	 public ModelAndView getAll(){
		 
		 mav = new ModelAndView("/prestamos/listado");
		 List<Prestamo> prestamos = ps.getAll();
		 mav.addObject("listado-prestamos", prestamos);
		 
		 return mav;
	 }
	 
	 @RequestMapping(value = "delete/{id}", method = {RequestMethod.POST, RequestMethod.DELETE})
	 public String delete(@PathVariable("id") int id){
		 
		 ps.delete(id);
		 return "redirect:/prestamos";
	 }
	
	@RequestMapping(value = "/restclients", method = RequestMethod.GET)
	public String restRedirect(Model model){
		return "prestamos/listadoRest";
	}
	

}
