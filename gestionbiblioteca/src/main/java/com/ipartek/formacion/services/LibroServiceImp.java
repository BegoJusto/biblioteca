package com.ipartek.formacion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ipartek.formacion.dao.EjemplarDAOImp;
import com.ipartek.formacion.dao.LibroDAOImp;
import com.ipartek.formacion.dao.persistencia.Libro;
import com.ipartek.formacion.services.interfaces.LibroService;

public class LibroServiceImp implements LibroService {

	@Autowired
	private LibroDAOImp libroDAO;
	
//	@Override
//	public Libro create(Libro libro) {
//		
//		return libroDAO.create(libro);
//	}

	@Override
	public List<Libro> getAll() {
		
		return libroDAO.getAll();
	}
//
//	@Override
//	public Libro getById(int id) {
//		
//		return libroDAO.getById(id);
//	}
////
//	@Override
//	public Libro update(Libro libro) {
//		
//		return libroDAO.update(libro);
//	}
//
//	@Override
//	public void delete(int id) {
//		
//		libroDAO.delete(id);
//	}

	@Override
	public void setLibroDAO(LibroDAOImp libroDAO) {
		
		this.libroDAO = libroDAO;
	}

	@Override
	public void addEjemplar(EjemplarDAOImp ejemplarDAO) {
		// TODO Auto-generated method stub
		
	}

}
